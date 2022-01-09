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
import com.esc.practice.apps.notes.dto.request.UpdateNotesRequest;
import com.esc.practice.apps.notes.dto.response.UpdateNotesResponse;
import com.esc.practice.apps.notes.utils.NotesUtil;


@Component
public class UpdateNotesValidator implements INotesValidator<UpdateNotesRequest, UpdateNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(UpdateNotesValidator.class);

	@Override
	public UpdateNotesResponse validateRequest(UpdateNotesRequest request) {
		logger.info("Request received in UpdateNotesValidator...");
		UpdateNotesResponse response = null;
		if (request != null) {
			if (NotesUtil.isEmpty(request.getNotesId())) {
				logger.error("The notes id is empty...");
				response = new UpdateNotesResponse();
				response.setErrorType(INotesConstants.VALIDATION_ERROR);
				response.setResponseCode(INotesRespCode.EMPTY_ID);
				response.setResponseMsg(INotesRespMessage.EMPTY_ID);
			} else if (NotesUtil.isEmpty(request.getBody())) {
				logger.error("The notes body is empty...");
				response = new UpdateNotesResponse();
				response.setErrorType(INotesConstants.VALIDATION_ERROR);
				response.setResponseCode(INotesRespCode.EMPTY_BODY);
				response.setResponseMsg(INotesRespMessage.EMPTY_BODY);
			} else {
				boolean isAllAttachmentFieldsFilled = request.getAttachment() != null
						&& (!NotesUtil.isEmpty(request.getAttachmentName()))
						&& (!NotesUtil.isEmpty(request.getAttachmentType()));
				boolean isAllAttachmentFieldsBlank = request.getAttachment() == null
						&& (NotesUtil.isEmpty(request.getAttachmentName()))
						&& (NotesUtil.isEmpty(request.getAttachmentType()));
				if (!isAllAttachmentFieldsFilled && !isAllAttachmentFieldsBlank) {
					logger.error("Attachment related fields validation failed: isAllAttachmentFieldsFilled: "
							+ isAllAttachmentFieldsFilled + " isAllAttachmentFieldsBlank: "
							+ isAllAttachmentFieldsBlank);
					response = new UpdateNotesResponse();
					response.setErrorType(INotesConstants.VALIDATION_ERROR);
					response.setResponseCode(INotesRespCode.INVALID_ATTACHMENT_INPUT);
					response.setResponseMsg(INotesRespMessage.INVALID_ATTACHMENT_INPUT);
				}
			}
		} else {
			response = new UpdateNotesResponse();
			response.setErrorType(INotesConstants.VALIDATION_ERROR);
			response.setResponseCode(INotesRespCode.EMPTY_REQ);
			response.setResponseMsg(INotesRespMessage.EMPTY_REQ);
		}
		return response;
	}

}
