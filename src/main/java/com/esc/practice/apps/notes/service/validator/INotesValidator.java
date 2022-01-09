/**
 * 
 */
package com.esc.practice.apps.notes.service.validator;

/**
 * @author Syed Abbas Ali
 *
 */
public interface INotesValidator<TRequest, TResponse> {

	/**
	 * This method validates the incoming request as per the business rules
	 * 
	 * @param request
	 * @return
	 */
	TResponse validateRequest(TRequest request);
}
