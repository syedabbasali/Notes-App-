/**
 * 
 */
package com.esc.practice.apps.notes.constant;

/**
 * @author Syed Abbas Ali
 *
 */
public interface INotesRespMessage {

	String SUCCESS = "SUCCESS";

	String SYS_ERROR = "Internal System Error Occured!";

	String EMPTY_REQ = "The request body is empty!";

	String EMPTY_BODY = "The notes body is empty!";

	String EMPTY_ID = "The notes id is empty!";

	String INVALID_FILE = "The entered file is not supported! Please check the supported file formats and try again!";

	String INVALID_FILE_SIZE = "The entered file is larger than what it is supposed to be!";

	String INVALID_ATTACHMENT_INPUT = "Either fill all the attachment related fields or don't fill any of them..";
}
