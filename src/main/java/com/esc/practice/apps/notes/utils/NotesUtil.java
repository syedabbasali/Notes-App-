/**
 * 
 */
package com.esc.practice.apps.notes.utils;

import java.util.Collection;

/**
 * @author Syed Abbas Ali
 *
 */
public class NotesUtil {

	// private static final Logger logger =
	// LoggerFactory.getLogger(NotesUtil.class);

	/**
	 * This method returns if an object is empty or not
	 * 
	 * @param input
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object input) {
		boolean isEmpty = false;
		if (input == null) {
			isEmpty = true;
		} else if (input instanceof String) {
			String s = (String) input;
			if (s == null || s.isEmpty()) {
				isEmpty = true;
			}
		} else if (input instanceof Collection) {
			Collection s = (Collection) input;
			if (s == null || s.isEmpty()) {
				isEmpty = true;
			}
		}
		return isEmpty;
	}
	
}
