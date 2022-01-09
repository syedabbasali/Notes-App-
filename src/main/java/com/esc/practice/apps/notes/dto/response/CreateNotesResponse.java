/**
 * 
 */
package com.esc.practice.apps.notes.dto.response;

/**
 * @author Syed Abbas Ali
 *
 */
public class CreateNotesResponse extends NotesBaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6386135440229104392L;

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
}
