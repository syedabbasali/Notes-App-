/**
 * 
 */
package com.esc.practice.apps.notes.dao.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Syed Abbas Ali
 *
 */
@Entity
@Table(name = "notes_tbl")
@SequenceGenerator(name = "notes_tbl_seq", sequenceName = "notes_tbl_seq", initialValue = 1, allocationSize = 1)
public class Notes {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notes_tbl_seq")
	private Long notesId = null;

	@Column(name = "title", length = 255)
	private String title = null;

	@Column(name = "author_name", length = 100)
	private String authorName = null;

	@Column(name = "body")
	private String body = null;

	@Column(name = "attachment")
	private byte[] attachment = null;

	@Column(name = "attachment_name")
	private String attachmentName = null;

	@Column(name = "attachment_type")
	private String attachmentType = null;

	@Column(name = "created_date", updatable = false)
	private Date createdDate = null;

	@Column(name = "modified_date")
	private Date modifiedDate = null;

	/**
	 * @return the notesId
	 */
	public Long getNotesId() {
		return notesId;
	}

	/**
	 * @param notesId the notesId to set
	 */
	public void setNotesId(Long notesId) {
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
	public byte[] getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(byte[] attachment) {
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

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Notes [notesId=" + notesId + ", title=" + title + ", authorName=" + authorName + ", body=" + body
				+ ", attachment=" + Arrays.toString(attachment) + ", attachmentName=" + attachmentName
				+ ", attachmentType=" + attachmentType + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

}
