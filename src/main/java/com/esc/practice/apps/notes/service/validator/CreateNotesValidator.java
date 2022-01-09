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
import com.esc.practice.apps.notes.dto.request.CreateNotesRequest;
import com.esc.practice.apps.notes.dto.response.CreateNotesResponse;
import com.esc.practice.apps.notes.utils.NotesUtil;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class CreateNotesValidator implements INotesValidator<CreateNotesRequest, CreateNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(CreateNotesValidator.class);

	@Override
	public CreateNotesResponse validateRequest(CreateNotesRequest request) {
		logger.info("Request received in CreateNotesValidator...");
		CreateNotesResponse response = null;
		if (request != null) {
			if (NotesUtil.isEmpty(request.getBody())) {
				logger.error("The notes body is empty...");
				response = new CreateNotesResponse();
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
					response = new CreateNotesResponse();
					response.setErrorType(INotesConstants.VALIDATION_ERROR);
					response.setResponseCode(INotesRespCode.INVALID_ATTACHMENT_INPUT);
					response.setResponseMsg(INotesRespMessage.INVALID_ATTACHMENT_INPUT);
				}
			}
		} else {
			response = new CreateNotesResponse();
			response.setErrorType(INotesConstants.VALIDATION_ERROR);
			response.setResponseCode(INotesRespCode.EMPTY_REQ);
			response.setResponseMsg(INotesRespMessage.EMPTY_REQ);
		}
		return response;
	}

}
