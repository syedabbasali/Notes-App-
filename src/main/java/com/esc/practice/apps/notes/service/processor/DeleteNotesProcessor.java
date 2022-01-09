/**
 * 
 */
package com.esc.practice.apps.notes.service.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esc.practice.apps.notes.constant.INotesRespCode;
import com.esc.practice.apps.notes.constant.INotesRespMessage;
import com.esc.practice.apps.notes.dao.impl.NotesDaoServiceImpl;
import com.esc.practice.apps.notes.dto.request.DeleteNotesRequest;
import com.esc.practice.apps.notes.dto.response.DeleteNotesResponse;
import com.esc.practice.apps.notes.exception.NotesException;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class DeleteNotesProcessor implements INotesProcessor<DeleteNotesRequest, DeleteNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(UpdateNotesProcessor.class);

	@Autowired
	private NotesDaoServiceImpl notesDaoService;

	@Override
	public DeleteNotesResponse processRequest(DeleteNotesRequest request) throws NotesException {
		logger.info("Request received in DeleteNotesProcessor...");
		DeleteNotesResponse response = null;
		try {
			notesDaoService.deleteNotes(request.getNotesId());
		} catch (NotesException e) {
			logger.error("Error while deleteing notes, ", e);
			throw new NotesException(e);
		}
		response = new DeleteNotesResponse();
		response.setResponseCode(INotesRespCode.SUCCESS);
		response.setResponseMsg(INotesRespMessage.SUCCESS);
		return response;
	}
}
