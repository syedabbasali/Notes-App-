/**
 * 
 */
package com.esc.practice.apps.notes.dto.response;

import java.io.Serializable;

/**
 * @author Syed Abbas Ali
 *
 */
public class NotesBaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4243527116709036324L;

	private String responseMsg = null;

	private String responseCode = null;

	private String errorType = null;

	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * @param responseMsg the responseMsg to set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
}
