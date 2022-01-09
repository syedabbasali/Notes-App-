/**
 * 
 */
package com.esc.practice.apps.notes.exception;

/**
 * @author Syed Abbas Ali
 *
 */
public class NotesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2391907902095461005L;

	public NotesException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotesException(String arg0) {
		super(arg0);
	}

	public NotesException(Throwable arg0) {
		super(arg0);
	}

}
