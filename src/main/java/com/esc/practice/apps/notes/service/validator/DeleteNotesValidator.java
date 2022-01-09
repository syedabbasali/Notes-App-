/**
 * 
 */
package com.esc.practice.apps.notes.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.esc.practice.apps.notes.constant.INotesConstants;
import com.esc.practice.apps.notes.constant.INotesRespCode;
import com.esc.practice.apps.notes.constant.INotesRespMessage;
import com.esc.practice.apps.notes.dto.request.DeleteNotesRequest;
import com.esc.practice.apps.notes.dto.response.DeleteNotesResponse;
import com.esc.practice.apps.notes.utils.NotesUtil;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class DeleteNotesValidator implements INotesValidator<DeleteNotesRequest, DeleteNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(DeleteNotesValidator.class);

	@Override
	public DeleteNotesResponse validateRequest(DeleteNotesRequest request) {
		logger.info("Request received in DeleteNotesValidator...");
		DeleteNotesResponse response = null;
		if (request != null) {
			if (NotesUtil.isEmpty(request.getNotesId())) {
				logger.error("The notes id is empty...");
				response = new DeleteNotesResponse();
				response.setErrorType(INotesConstants.VALIDATION_ERROR);
				response.setResponseCode(INotesRespCode.EMPTY_ID);
				response.setResponseMsg(INotesRespMessage.EMPTY_ID);
			}
		} else {
			response = new DeleteNotesResponse();
			response.setErrorType(INotesConstants.VALIDATION_ERROR);
			response.setResponseCode(INotesRespCode.EMPTY_REQ);
			response.setResponseMsg(INotesRespMessage.EMPTY_REQ);
		}
		return response;
	}

}
