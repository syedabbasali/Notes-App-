/**
 * 
 */
package com.esc.practice.apps.notes.service.processor;

import java.util.Base64;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esc.practice.apps.notes.constant.INotesConstants;
import com.esc.practice.apps.notes.constant.INotesRespCode;
import com.esc.practice.apps.notes.constant.INotesRespMessage;
import com.esc.practice.apps.notes.dao.impl.NotesDaoServiceImpl;
import com.esc.practice.apps.notes.dto.NotesVO;
import com.esc.practice.apps.notes.dto.request.UpdateNotesRequest;
import com.esc.practice.apps.notes.dto.response.UpdateNotesResponse;
import com.esc.practice.apps.notes.exception.NotesException;
import com.esc.practice.apps.notes.utils.NotesUtil;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class UpdateNotesProcessor implements INotesProcessor<UpdateNotesRequest, UpdateNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(UpdateNotesProcessor.class);

	@Autowired
	private NotesDaoServiceImpl notesDaoService;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public UpdateNotesResponse processRequest(UpdateNotesRequest request) throws NotesException {
		logger.info("Request received in UpdateNotesProcessor...");
		UpdateNotesResponse response = null;
		NotesVO dataVO = new NotesVO();
		try {
			dataVO = dozer.map(request, NotesVO.class);
			if (!NotesUtil.isEmpty(request.getAttachment())) {
				byte[] data = Base64.getDecoder().decode(request.getAttachment());
				dataVO.setAttachment(data);
			}
			dataVO = notesDaoService.saveAndUpdateNotes(dataVO);
		} catch (MappingException e) {
			logger.error("Error while doing dozer convertion, ", e);
			throw new NotesException(e);
		} catch (NotesException e) {
			logger.error("Error while updating notes, ", e);
			throw new NotesException(e);
		}
		if (dataVO != null && !NotesUtil.isEmpty(dataVO.getModifiedDate())) {
			response = new UpdateNotesResponse();
			response.setResponseCode(INotesRespCode.SUCCESS);
			response.setResponseMsg(INotesRespMessage.SUCCESS);
		} else {
			response = new UpdateNotesResponse();
			response.setErrorType(INotesConstants.SYS_ERROR);
			response.setResponseCode(INotesRespCode.SYS_ERROR);
			response.setResponseMsg(INotesRespMessage.SYS_ERROR);
		}
		return response;
	}
}
