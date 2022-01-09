/**
 * 
 */
package com.esc.practice.apps.notes.dto.request;

/**
 * @author Syed Abbas Ali
 *
 */
public class GetNotesRequest extends NotesBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -19414142767291512L;

	private String notesId = null;

	private String title = null;

	private String authorName = null;

	private String body = null;

	private Boolean hasAttachment = null;

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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the hasAttachment
	 */
	public Boolean getHasAttachment() {
		return hasAttachment;
	}

	/**
	 * @param hasAttachment the hasAttachment to set
	 */
	public void setHasAttachment(Boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	@Override
	public String toString() {
		return "GetNotesRequest [notesId=" + notesId + ", title=" + title + ", authorName=" + authorName + ", body="
				+ body + ", hasAttachment=" + hasAttachment + "]";
	}

}
