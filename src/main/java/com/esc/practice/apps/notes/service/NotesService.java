/**
 * 
 */
package com.esc.practice.apps.notes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esc.practice.apps.notes.constant.INotesConstants;
import com.esc.practice.apps.notes.constant.INotesRespCode;
import com.esc.practice.apps.notes.constant.INotesRespMessage;
import com.esc.practice.apps.notes.dto.request.CreateNotesRequest;
import com.esc.practice.apps.notes.dto.request.DeleteNotesRequest;
import com.esc.practice.apps.notes.dto.request.GetNotesRequest;
import com.esc.practice.apps.notes.dto.request.UpdateNotesRequest;
import com.esc.practice.apps.notes.dto.response.CreateNotesResponse;
import com.esc.practice.apps.notes.dto.response.DeleteNotesResponse;
import com.esc.practice.apps.notes.dto.response.GetNotesResponse;
import com.esc.practice.apps.notes.dto.response.UpdateNotesResponse;
import com.esc.practice.apps.notes.exception.NotesException;
import com.esc.practice.apps.notes.service.processor.CreateNotesProcessor;
import com.esc.practice.apps.notes.service.processor.DeleteNotesProcessor;
import com.esc.practice.apps.notes.service.processor.GetNotesProcessor;
import com.esc.practice.apps.notes.service.processor.UpdateNotesProcessor;
import com.esc.practice.apps.notes.service.validator.CreateNotesValidator;
import com.esc.practice.apps.notes.service.validator.DeleteNotesValidator;
import com.esc.practice.apps.notes.service.validator.GetNotesValidator;
import com.esc.practice.apps.notes.service.validator.UpdateNotesValidator;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class NotesService {

	private static final Logger logger = LoggerFactory.getLogger(NotesService.class);

	@Autowired
	private CreateNotesValidator createNotesValidator;

	@Autowired
	private CreateNotesProcessor createNotesProcessor;

	@Autowired
	private UpdateNotesValidator updateNotesValidator;

	@Autowired
	private UpdateNotesProcessor updateNotesProcessor;

	@Autowired
	private GetNotesValidator getNotesValidator;

	@Autowired
	private GetNotesProcessor getNotesProcessor;

	@Autowired
	private DeleteNotesValidator deleteNotesValidator;

	@Autowired
	private DeleteNotesProcessor deleteNotesProcessor;

	/**
	 * This method accepts the request from controller and pass it over to
	 * validators and processors
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <TRequest, TResponse> TResponse callService(TRequest request) {
		logger.info("Request received in service layer...");
		if (request instanceof CreateNotesRequest) {
			CreateNotesResponse response = null;
			try {
				response = createNotesValidator.validateRequest((CreateNotesRequest) request);
				if (response == null) {
					response = createNotesProcessor.processRequest((CreateNotesRequest) request);
				}
			} catch (NotesException e) {
				logger.error("Error while saving notes, ", e);
				response = new CreateNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			} catch (Exception e) {
				logger.error("Error while saving notes, ", e);
				response = new CreateNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			}
			return (TResponse) response;
		} else if (request instanceof UpdateNotesRequest) {
			UpdateNotesResponse response = null;
			try {
				response = updateNotesValidator.validateRequest((UpdateNotesRequest) request);
				if (response == null) {
					response = updateNotesProcessor.processRequest((UpdateNotesRequest) request);
				}
			} catch (NotesException e) {
				logger.error("Error while updating notes, ", e);
				response = new UpdateNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			} catch (Exception e) {
				logger.error("Error while updating notes, ", e);
				response = new UpdateNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			}
			return (TResponse) response;
		} else if (request instanceof GetNotesRequest) {
			GetNotesResponse response = null;
			try {
				response = getNotesValidator.validateRequest((GetNotesRequest) request);
				if (response == null) {
					response = getNotesProcessor.processRequest((GetNotesRequest) request);
				}
			} catch (NotesException e) {
				logger.error("Error while fetching notes, ", e);
				response = new GetNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			} catch (Exception e) {
				logger.error("Error while fetching notes, ", e);
				response = new GetNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			}
			return (TResponse) response;
		} else if (request instanceof DeleteNotesRequest) {
			DeleteNotesResponse response = null;
			try {
				response = deleteNotesValidator.validateRequest((DeleteNotesRequest) request);
				if (response == null) {
					response = deleteNotesProcessor.processRequest((DeleteNotesRequest) request);
				}
			} catch (NotesException e) {
				logger.error("Error while deleting notes, ", e);
				response = new DeleteNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			} catch (Exception e) {
				logger.error("Error while deleting notes, ", e);
				response = new DeleteNotesResponse();
				response.setErrorType(INotesConstants.SYS_ERROR);
				response.setResponseCode(INotesRespCode.SYS_ERROR);
				response.setResponseMsg(INotesRespMessage.SYS_ERROR);
			}
			return (TResponse) response;
		}
		return null;
	}
}
