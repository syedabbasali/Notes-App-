/**
 * 
 */
package com.esc.practice.apps.notes.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esc.practice.apps.notes.constant.INotesConstants;
import com.esc.practice.apps.notes.constant.INotesRespCode;
import com.esc.practice.apps.notes.dto.request.CreateNotesRequest;
import com.esc.practice.apps.notes.dto.request.DeleteNotesRequest;
import com.esc.practice.apps.notes.dto.request.GetNotesRequest;
import com.esc.practice.apps.notes.dto.request.UpdateNotesRequest;
import com.esc.practice.apps.notes.dto.response.CreateNotesResponse;
import com.esc.practice.apps.notes.dto.response.DeleteNotesResponse;
import com.esc.practice.apps.notes.dto.response.GetNotesResponse;
import com.esc.practice.apps.notes.dto.response.UpdateNotesResponse;
import com.esc.practice.apps.notes.service.NotesService;
import com.esc.practice.apps.notes.utils.NotesUtil;

/**
 * @author Syed Abbas Ali
 *
 */
@RestController
@RequestMapping("/notes")
public class NotesController {

	private static final Logger logger = LoggerFactory.getLogger(NotesController.class);

	@Autowired
	private NotesService notesService;

	/**
	 * This method is http endpoint for create notes
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<CreateNotesResponse> createNotes(@RequestBody CreateNotesRequest request) {
		logger.info("Request received in controller to createNotes...");
		ResponseEntity<CreateNotesResponse> httpResponse = null;
		CreateNotesResponse response = null;
		if (request != null) {
			response = (CreateNotesResponse) notesService.callService(request);
		}
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		if (response != null) {
			if (INotesRespCode.SUCCESS.equals(response.getResponseCode())) {
				httpStatus = HttpStatus.OK;
			} else if (INotesConstants.VALIDATION_ERROR.equals(response.getErrorType())) {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		}

		httpResponse = new ResponseEntity<CreateNotesResponse>(response, httpStatus);
		logger.info("Returning response with http code: " + httpStatus.value());
		return httpResponse;
	}

	/**
	 * This method is http endpoint for update notes
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/update")
	public ResponseEntity<UpdateNotesResponse> updateNotes(@RequestBody UpdateNotesRequest request) {
		logger.info("Request received in controller to updateNotes...");
		ResponseEntity<UpdateNotesResponse> httpResponse = null;
		UpdateNotesResponse response = null;
		if (request != null) {
			response = (UpdateNotesResponse) notesService.callService(request);
		}
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		if (response != null) {
			if (INotesRespCode.SUCCESS.equals(response.getResponseCode())) {
				httpStatus = HttpStatus.OK;
			} else if (INotesConstants.VALIDATION_ERROR.equals(response.getErrorType())) {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		}

		httpResponse = new ResponseEntity<UpdateNotesResponse>(response, httpStatus);
		logger.info("Returning response with http code: " + httpStatus.value());
		return httpResponse;
	}

	/**
	 * This method is http endpoint for get notes
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/fetch")
	public ResponseEntity<GetNotesResponse> getNotes(@RequestBody GetNotesRequest request) {
		logger.info("Request received in controller to getNotes...");
		ResponseEntity<GetNotesResponse> httpResponse = null;
		GetNotesResponse response = null;
		if (request != null) {
			response = (GetNotesResponse) notesService.callService(request);
		}
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		if (response != null) {
			if (INotesRespCode.SUCCESS.equals(response.getResponseCode())) {
				if (!NotesUtil.isEmpty(response.getDataList())) {
					httpStatus = HttpStatus.OK;
				} else {
					httpStatus = HttpStatus.NO_CONTENT;
				}
			} else if (INotesConstants.VALIDATION_ERROR.equals(response.getErrorType())) {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		}

		httpResponse = new ResponseEntity<GetNotesResponse>(response, httpStatus);
		logger.info("Returning response with http code: " + httpStatus.value());
		return httpResponse;
	}

	/**
	 * This method is http endpoint for delete notes
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/delete")
	public ResponseEntity<DeleteNotesResponse> deleteNotes(@RequestBody DeleteNotesRequest request) {
		logger.info("Request received in controller to getNotes...");
		ResponseEntity<DeleteNotesResponse> httpResponse = null;
		DeleteNotesResponse response = null;
		if (request != null) {
			response = (DeleteNotesResponse) notesService.callService(request);
		}
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		if (response != null) {
			if (INotesRespCode.SUCCESS.equals(response.getResponseCode())) {
				httpStatus = HttpStatus.OK;
			} else if (INotesConstants.VALIDATION_ERROR.equals(response.getErrorType())) {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		}

		httpResponse = new ResponseEntity<DeleteNotesResponse>(response, httpStatus);
		logger.info("Returning response with http code: " + httpStatus.value());
		return httpResponse;
	}

}
