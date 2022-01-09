/**
 * 
 */
package com.esc.practice.apps.notes.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.esc.practice.apps.notes.dto.NotesVO;

/**
 * @author Syed Abbas Ali
 *
 */
public class GetNotesResponse extends NotesBaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8699826504985292451L;

	private List<NotesVO> dataList = new ArrayList<NotesVO>();

	/**
	 * @return the dataList
	 */
	public List<NotesVO> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<NotesVO> dataList) {
		this.dataList = dataList;
	}

}
