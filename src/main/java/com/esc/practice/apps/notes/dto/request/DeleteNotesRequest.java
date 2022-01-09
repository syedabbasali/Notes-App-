/**
 * 
 */
package com.esc.practice.apps.notes.dto.request;

/**
 * @author Syed Abbas Ali
 *
 */
public class DeleteNotesRequest extends NotesBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8692025996508094118L;

	private String notesId = null;

	/**
	 * @return the notesId
	 */
	public String getNotesId() {
		return notesId;
	}

	/**
	 * @param notesId the notesId to set
	 */
	public void setNotesId(String notesId) {
		this.notesId = notesId;
	}

	@Override
	public String toString() {
		return "DeleteNotesRequest [notesId=" + notesId + "]";
	}
}
