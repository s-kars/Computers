package com.skars.computers.util.hibernate;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.skars.computers.util.IConstants;
import com.skars.computers.util.logging.Log4jUtil;

/**
 * This filter allows wrap for transaction user's request.
 * 
 * @author skars
 */
public class TransactionInterseptor implements Interceptor {

	/** Logging all events. */
	private static final Logger logger = Logger.getLogger(TransactionInterseptor.class);
	
	/** Identifier for serialization. */
	private static final long serialVersionUID = -39700888358100238L;
	
	/** Utility for operations with session of Hibernate. */
	private HibernateUtil hibernateUtil;
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		Log4jUtil.debug(logger, "Initialize " + getClass().getSimpleName());
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(IConstants.SPRING_CONTEXT_LOCATION);
		hibernateUtil = springContext.getBean(HibernateUtil.class);
	}

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Log4jUtil.debug(logger, "Execute interception of " + getClass().getSimpleName());
		String result = null;
		
		hibernateUtil.beginTransaction();
		result = invocation.invoke();
		hibernateUtil.commitTransaction();
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		Log4jUtil.debug(logger, "Destroy " + getClass().getSimpleName());
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
