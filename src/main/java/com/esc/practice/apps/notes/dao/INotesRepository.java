/**
 * 
 */
package com.esc.practice.apps.notes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esc.practice.apps.notes.dao.model.Notes;

/**
 * @author Syed Abbas Ali
 *
 */
@Repository
public interface INotesRepository extends CrudRepository<Notes, Long> {

}
