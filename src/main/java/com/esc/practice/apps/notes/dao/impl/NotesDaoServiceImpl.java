/**
 * 
 */
package com.esc.practice.apps.notes.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esc.practice.apps.notes.dao.INotesDaoService;
import com.esc.practice.apps.notes.dao.INotesRepository;
import com.esc.practice.apps.notes.dao.NotesQueryRepositoryImpl;
import com.esc.practice.apps.notes.dao.model.Notes;
import com.esc.practice.apps.notes.dto.NotesQueryVO;
import com.esc.practice.apps.notes.dto.NotesVO;
import com.esc.practice.apps.notes.exception.NotesException;
import com.esc.practice.apps.notes.utils.NotesUtil;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class NotesDaoServiceImpl implements INotesDaoService {

	private static final Logger logger = LoggerFactory.getLogger(NotesQueryRepositoryImpl.class);

	@Autowired
	private INotesRepository notesRepository;

	@Autowired
	private NotesQueryRepositoryImpl notesQueryRepository;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public NotesVO saveAndUpdateNotes(NotesVO data) throws NotesException {
		logger.info("Request received in the dao layer to save or update...");
		Notes note = new Notes();
		try {
			note = dozer.map(data, Notes.class);
			if (note != null) {
				if (note.getNotesId() == null) {
					note.setCreatedDate(new Date());
				} else {
					note.setModifiedDate(new Date());
				}
				note = notesRepository.save(note);
				data = dozer.map(note, NotesVO.class);
			}
		} catch (MappingException e) {
			logger.error("Error while doing dozer convertion, ", e);
			throw new NotesException(e);
		} catch (Exception e) {
			logger.error("Unkown exception, ", e);
			throw new NotesException(e);
		}
		return data;
	}

	@Override
	public List<NotesVO> fetchNotes(NotesQueryVO data) throws NotesException {
		logger.info("Request received in the dao layer to fetch data...");
		List<NotesVO> notesVOList = new ArrayList<>();
		try {
			List<Notes> notesList = notesQueryRepository.fetchNotesDetails(data);
			if (!NotesUtil.isEmpty(notesList)) {
				for (Notes notes : notesList) {
					NotesVO dataVO = new NotesVO();
					dataVO = dozer.map(notes, NotesVO.class);
					notesVOList.add(dataVO);
				}
			}
		} catch (MappingException e) {
			logger.error("Error while doing dozer convertion, ", e);
			throw new NotesException(e);
		} catch (Exception e) {
			logger.error("Unkown exception, ", e);
			throw new NotesException(e);
		}
		return notesVOList;
	}

	@Override
	public void deleteNotes(String id) throws NotesException {
		logger.info("Request received in the dao layer to delete data...");
		try {
			notesRepository.deleteById(Long.parseLong(id));
		} catch (Exception e) {
			logger.error("Unkown exception, ", e);
			throw new NotesException(e);
		}
	}

}
