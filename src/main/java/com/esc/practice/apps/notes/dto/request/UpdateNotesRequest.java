/**
 * 
 */
package com.esc.practice.apps.notes.dto.request;

/**
 * @author Syed Abbas Ali
 *
 */
public class UpdateNotesRequest extends NotesBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3892324435008795697L;

	private String notesId = null;

	private String title = null;

	private String authorName = null;

	private String body = null;

	private String attachment = null;

	private String attachmentName = null;

	private String attachmentType = null;

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
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the attachmentName
	 */
	public String getAttachmentName() {
		return attachmentName;
	}

	/**
	 * @param attachmentName the attachmentName to set
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	/**
	 * @return the attachmentType
	 */
	public String getAttachmentType() {
		return attachmentType;
	}

	/**
	 * @param attachmentType the attachmentType to set
	 */
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	@Override
	public String toString() {
		return "UpdateNotesRequest [notesId=" + notesId + ", title=" + title + ", authorName=" + authorName + ", body="
				+ body + ", attachment=" + attachment + ", attachmentName=" + attachmentName + ", attachmentType="
				+ attachmentType + "]";
	}

}
