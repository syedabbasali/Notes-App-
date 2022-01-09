/**
 * 
 */
package com.esc.practice.apps.notes.dao;

import java.util.List;

import com.esc.practice.apps.notes.dto.NotesQueryVO;
import com.esc.practice.apps.notes.dto.NotesVO;
import com.esc.practice.apps.notes.exception.NotesException;

/**
 * @author Syed Abbas Ali
 *
 */
public interface INotesDaoService {

	/**
	 * This method saves or updates the notes object into the datastore
	 * 
	 * @param data
	 * @return
	 * @throws NotesException 
	 */
	NotesVO saveAndUpdateNotes(NotesVO data) throws NotesException;

	/**
	 * This method fetches the notes from DB matching the given criteria
	 * 
	 * @param data
	 * @return
	 * @throws NotesException 
	 */
	List<NotesVO> fetchNotes(NotesQueryVO data) throws NotesException;

	/**
	 * This method deletes the notes on the given notes id
	 * 
	 * @param id
	 * @throws NotesException 
	 */
	void deleteNotes(String id) throws NotesException;
}
