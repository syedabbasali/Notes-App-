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
import com.esc.practice.apps.notes.dto.request.GetNotesRequest;
import com.esc.practice.apps.notes.dto.response.GetNotesResponse;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class GetNotesValidator implements INotesValidator<GetNotesRequest, GetNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(GetNotesValidator.class);

	@Override
	public GetNotesResponse validateRequest(GetNotesRequest request) {
		logger.info("Request received in GetNotesValidator...");
		GetNotesResponse response = null;
		if (request != null) {
			/*if (NotesUtil.isEmpty(request.getAuthorName()) && NotesUtil.isEmpty(request.getBody())
					&& NotesUtil.isEmpty(request.getNotesId()) && NotesUtil.isEmpty(request.getHasAttachment())
					&& NotesUtil.isEmpty(request.getTitle())) {
				logger.error("The notes body is empty...");
				response = new GetNotesResponse();
				response.setErrorType(INotesConstants.VALIDATION_ERROR);
				response.setResponseCode(INotesRespCode.EMPTY_REQ);
				response.setResponseMsg(INotesRespMessage.EMPTY_REQ);
			}*/
		} else {
			response = new GetNotesResponse();
			response.setErrorType(INotesConstants.VALIDATION_ERROR);
			response.setResponseCode(INotesRespCode.EMPTY_REQ);
			response.setResponseMsg(INotesRespMessage.EMPTY_REQ);
		}
		return response;
	}

}
