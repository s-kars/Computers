package com.skars.computers.dataservice;

import java.util.List;

import org.apache.log4j.Logger;

import com.skars.computers.model.Detail;
import com.skars.computers.util.hibernate.HibernateUtil;
import com.skars.computers.util.logging.Log4jUtil;

/**
 * Implementation of generic data service.
 * 
 * @author skars
 */
public class GenericDataService<T extends Detail> implements IGenericDataService<T> {

	/** Logger for all events. */
	private static final Logger logger = Logger.getLogger(GenericDataService.class);
	
	/** Type of entity. */
	private Class<T> type;
	
	/** Utility for operations with session of Hibernate. */
	private HibernateUtil hibernateUtil;
	
	/**
	 * Constructs generic data service.
	 * 
	 * @param type Type of entity.
	 */
	public GenericDataService(Class<T> type) {
		setType(type);
	}

	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.dao.IGenericDao#get(long)
	 */
	@SuppressWarnings("unchecked")
	public T get(long id) throws IllegalArgumentException {
		Log4jUtil.debug(logger, "Get " + getType().getSimpleName() + " entity with id = " + id + " from data storage");
		if (id <= 0) {
			throw new IllegalArgumentException("Identifier can not be less or equals 0");
		}
		
		T entity = (T) getHibernateUtil().getSession().get(getType(), id);
		Log4jUtil.debug(logger, "Successfull operation for " + getType().getSimpleName() + " entity");
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.dao.IGenericDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Log4jUtil.debug(logger, "Get all entities of " + getType().getSimpleName());
		List<T> entitiesList = getHibernateUtil().getSession().createCriteria(getType()).list();
		Log4jUtil.debug(logger, "Successfull operation for " + getType().getSimpleName() + " entities");
		return entitiesList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.dao.IGenericDao#remove(long)
	 */
	public void delete(long id) throws IllegalArgumentException {
		Log4jUtil.debug(logger, "Delete " + getType().getSimpleName() 
				+ " entity with id = " + id + " from data storage");
		
		if (id <= 0) {
			throw new IllegalArgumentException("Identifier can not be less or equals 0");
		}
		
		T entity = get(id);
		delete(entity);
		Log4jUtil.debug(logger, "Entity " + getType().getSimpleName() + " with id = " + id + " successfully deleted");
	}

	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.dao.IGenericDao#remove(java.lang.Object)
	 */
	public void delete(T entity) throws IllegalArgumentException {
		Log4jUtil.debug(logger, "Delete entity " + getType().getSimpleName() + " from data storage");
		if (entity == null) {
			throw new IllegalArgumentException("Entity " + getType().getSimpleName() + " can not be null");
		}
		
		getHibernateUtil().getSession().delete(entity);
		Log4jUtil.debug(logger, "Entity " + getType().getSimpleName() + " successfully deleted");
	}

	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.dao.IGenericDao#save(java.lang.Object)
	 */
	public void save(T entity) throws IllegalArgumentException {
		Log4jUtil.debug(logger, "Save " + getType().getSimpleName() + " entity to data storage");
		if (entity == null) {
			throw new IllegalArgumentException("Entity " + getType().getSimpleName() + " can not be null");
		}
		
		getHibernateUtil().getSession().save(entity);
		Log4jUtil.debug(logger, "Entity " + getType().getSimpleName() + " successfully saved");
	}

	/**
	 * Gets type of entity.
	 * 
	 * @return The type of entity.
	 */
	private Class<T> getType() {
		return type;
	}

	/**
	 * Sets type of entity.
	 * 
	 * @param type The type to set.
	 */
	private void setType(Class<T> type) {
		this.type = type;
	}
	
	/**
	 * Gets utility for operations with session of Hibernate.
	 * 
	 * @return The Hibernate utility.
	 */
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	/**
	 * Sets utility for operations with session of Hibernate.
	 * 
	 * @param hibernateUtil The utility to set.
	 */
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
}
