/**
 * 
 */
package com.esc.practice.apps.notes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esc.practice.apps.notes.dao.model.Notes;
import com.esc.practice.apps.notes.dto.NotesQueryVO;
import com.esc.practice.apps.notes.utils.NotesUtil;

/**
 * @author Syed Abbas Ali
 *
 */
@Repository
public class NotesQueryRepositoryImpl {

	private static final Logger logger = LoggerFactory.getLogger(NotesQueryRepositoryImpl.class);

	@Autowired
	private EntityManager entityManager;

	/**
	 * This method creates a custom query for fetching the results
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Notes> fetchNotesDetails(NotesQueryVO request) {
		logger.info("Request received to perform custom search operation...");
		List<Notes> notes = new ArrayList<>();
		String queryStr = getSelectQuery(request);
		logger.info("Query: " + queryStr);
		Query query = entityManager.createQuery(queryStr);
		notes = query.getResultList();
		logger.info("Rows returned after firing the query: " + notes.size());
		return notes;
	}

	/**
	 * This method creates the query evaluating the given request
	 * 
	 * @param request
	 * @return
	 */
	private String getSelectQuery(NotesQueryVO request) {
		StringBuilder query = new StringBuilder("SELECT entity FROM Notes entity");
		boolean isWhereClauseAdded = false;
		if (request != null) {
			if (!NotesUtil.isEmpty(request.getAuthorName())) {
				query.append(" WHERE entity.authorName = '");
				query.append(request.getAuthorName());
				query.append("'");
				isWhereClauseAdded = true;
			}
			if (!NotesUtil.isEmpty(request.getBody())) {
				if (isWhereClauseAdded) {
					query.append(" AND entity.body LIKE '%");
					query.append(request.getBody());
					query.append("%'");
				} else {
					query.append(" WHERE entity.body LIKE '%");
					query.append(request.getBody());
					query.append("%'");
					isWhereClauseAdded = true;
				}
			}
			if (!NotesUtil.isEmpty(request.getNotesId())) {
				if (isWhereClauseAdded) {
					query.append(" AND entity.notesId = ");
					query.append(request.getNotesId());
				} else {
					query.append(" WHERE entity.notesId = ");
					query.append(request.getNotesId());
					isWhereClauseAdded = true;
				}
			}
			if (!NotesUtil.isEmpty(request.getTitle())) {
				if (isWhereClauseAdded) {
					query.append(" AND entity.title LIKE '%");
					query.append(request.getTitle());
					query.append("%'");
				} else {
					query.append(" WHERE entity.title LIKE '%");
					query.append(request.getTitle());
					query.append("%'");
					isWhereClauseAdded = true;
				}
			}
			if (!NotesUtil.isEmpty(request.getHasAttachment())) {
				if (isWhereClauseAdded) {
					if (request.getHasAttachment()) {
						query.append(" AND entity.attachment IS NOT NULL");
					} else {
						query.append(" AND entity.attachment IS NULL");
					}
				} else {
					if (request.getHasAttachment()) {
						query.append(" WHERE entity.attachment IS NOT NULL");
					} else {
						query.append(" WHERE entity.attachment IS NULL");
					}
					isWhereClauseAdded = true;
				}
			}
		}
		return query.toString();
	}
}
