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
import com.esc.practice.apps.notes.dto.request.CreateNotesRequest;
import com.esc.practice.apps.notes.dto.response.CreateNotesResponse;
import com.esc.practice.apps.notes.exception.NotesException;
import com.esc.practice.apps.notes.utils.NotesUtil;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class CreateNotesProcessor implements INotesProcessor<CreateNotesRequest, CreateNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(CreateNotesProcessor.class);

	@Autowired
	private NotesDaoServiceImpl notesDaoService;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public CreateNotesResponse processRequest(CreateNotesRequest request) throws NotesException {
		logger.info("Request received in CreateNotesProcessor...");
		CreateNotesResponse response = null;
		NotesVO dataVO = new NotesVO();
		try {
			dataVO = dozer.map(request, NotesVO.class);
			fillData(dataVO, request.getAttachment());
			dataVO = notesDaoService.saveAndUpdateNotes(dataVO);
		} catch (MappingException e) {
			logger.error("Error while doing dozer convertion, ", e);
			throw new NotesException(e);
		} catch (NotesException e) {
			logger.error("Error while saving notes, ", e);
			throw new NotesException(e);
		}
		if (dataVO != null && !NotesUtil.isEmpty(dataVO.getNotesId())) {
			response = new CreateNotesResponse();
			response.setNotesId(dataVO.getNotesId());
			response.setResponseCode(INotesRespCode.SUCCESS);
			response.setResponseMsg(INotesRespMessage.SUCCESS);
		} else {
			response = new CreateNotesResponse();
			response.setErrorType(INotesConstants.SYS_ERROR);
			response.setResponseCode(INotesRespCode.SYS_ERROR);
			response.setResponseMsg(INotesRespMessage.SYS_ERROR);
		}
		return response;
	}

	/**
	 * This method fills the necessary data in data vo
	 * 
	 * @param dataVO
	 * @param attachment
	 */
	private void fillData(NotesVO dataVO, String attachment) {
		if (dataVO != null) {
			if (NotesUtil.isEmpty(dataVO.getTitle())) {
				dataVO.setTitle("(untitled)");
			}
			if (!NotesUtil.isEmpty(attachment)) {
				byte[] data = Base64.getDecoder().decode(attachment);
				dataVO.setAttachment(data);
			}
		}
	}

}
