package com.skars.computers.dataservice;

import java.util.List;

import com.skars.computers.model.Detail;

/**
 * Interface for all data services in application.
 * 
 * @author skars
 */
public interface IGenericDataService<T extends Detail> {

	/**
	 * Gets entity from data storage.
	 * 
	 * @param id Entity identifier.
	 * @return Entity from storage or <code>null</code> if entity not exist. 
	 * @throws IllegalArgumentException If <code>id</code> is less or equals <code>0</code>.
	 */
	T get(long id) throws IllegalArgumentException;
	
	/**
	 * Gets all entities from data storage.
	 * 
	 * @return Returns all entities.
	 */
	List<T> getAll();
	
	/**
	 * Deletes entity from data storage.
	 * 
	 * @param id Entity identifier.
	 * IllegalArgumentException If <code>id</code> is less or equals <code>0</code>.
	 */
	void delete(long id) throws IllegalArgumentException;
	
	/**
	 * Deletes entity from data storage.
	 * 
	 * @param entity Entity for remove.
	 * @throws IllegalArgumentException If <code>entity</code> is <code>null</code>.
	 */
	void delete(T entity) throws IllegalArgumentException;
	
	/**
	 * Saves entity in data storage.
	 * 
	 * @param entity Entity for save.
	 * @throws IllegalArgumentException If <code>entity</code> is <code>null</code>.
	 */
	void save(T entity) throws IllegalArgumentException;
}
