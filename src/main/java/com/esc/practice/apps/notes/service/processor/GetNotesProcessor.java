/**
 * 
 */
package com.esc.practice.apps.notes.service.processor;

import java.util.List;

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
import com.esc.practice.apps.notes.dto.NotesQueryVO;
import com.esc.practice.apps.notes.dto.NotesVO;
import com.esc.practice.apps.notes.dto.request.GetNotesRequest;
import com.esc.practice.apps.notes.dto.response.GetNotesResponse;
import com.esc.practice.apps.notes.exception.NotesException;

/**
 * @author Syed Abbas Ali
 *
 */
@Component
public class GetNotesProcessor implements INotesProcessor<GetNotesRequest, GetNotesResponse> {

	private static final Logger logger = LoggerFactory.getLogger(GetNotesProcessor.class);

	@Autowired
	private NotesDaoServiceImpl notesDaoService;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public GetNotesResponse processRequest(GetNotesRequest request) throws NotesException {
		logger.info("Request received in GetNotesProcessor...");
		GetNotesResponse response = null;
		NotesQueryVO queryVO = new NotesQueryVO();
		List<NotesVO> dataVOList = null;
		try {
			queryVO = dozer.map(request, NotesQueryVO.class);
			dataVOList = notesDaoService.fetchNotes(queryVO);
		} catch (MappingException e) {
			logger.error("Error while doing dozer convertion, ", e);
			throw new NotesException(e);
		} catch (NotesException e) {
			logger.error("Error while fetching notes, ", e);
			throw new NotesException(e);
		}
		if (dataVOList != null) {
			response = new GetNotesResponse();
			response.setDataList(dataVOList);
			response.setResponseCode(INotesRespCode.SUCCESS);
			response.setResponseMsg(INotesRespMessage.SUCCESS);
		} else {
			response = new GetNotesResponse();
			response.setErrorType(INotesConstants.SYS_ERROR);
			response.setResponseCode(INotesRespCode.SYS_ERROR);
			response.setResponseMsg(INotesRespMessage.SYS_ERROR);
		}
		return response;
	}
}
