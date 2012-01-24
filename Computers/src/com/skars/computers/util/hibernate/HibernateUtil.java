package com.skars.computers.util.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skars.computers.util.logging.Log4jUtil;

/**
 * Utility for operations with sessions and transactions of Hibernate.
 * 
 * @author skars
 */
public class HibernateUtil {

	/** Logger for all events. */
	private static final Logger logger = Logger.getLogger(HibernateUtil.class);
	
	/** Thread with active session. */
	private static ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();
	
	/** Thread with active transaction. */
	private static ThreadLocal<Transaction> transactionThread = new ThreadLocal<Transaction>();
	
	/** Session provider. */
	private SessionFactory sessionFactory;
	
	/**
	 * Constructs utility.
	 */
	public HibernateUtil() {
		setSessionFactory(null);
	}

	/**
	 * Gets opened session.
	 * 
	 * @return Returns opened session.
	 */
	public Session getSession() {
		Log4jUtil.debug(logger, "Get session from local thread");
		Session session = sessionThread.get();
		
		if (session == null) {
			Log4jUtil.debug(logger, "Open session");
			session = sessionFactory.openSession();
			sessionThread.set(session);
		}
		
		return session;
	}
	
	/**
	 * Closes opened session. If session not open do nothing.
	 */
	public void closeSession() {
		Log4jUtil.debug(logger, "Get session from local thread");
		Session session = sessionThread.get();
		
		sessionThread.set(null);
		if ((session != null) && session.isOpen()) {
			Log4jUtil.debug(logger, "Close session");
			session.close();
		}
	}
	
	/**
	 * Begins transaction. If session is closed than it will be opened.
	 */
	public void beginTransaction() {
		Log4jUtil.debug(logger, "Get transaction from local thread");
		Transaction transaction = transactionThread.get();
		
		if (transaction == null) {
			Log4jUtil.debug(logger, "Begin transaction");
			transaction = getSession().beginTransaction();
			transactionThread.set(transaction);
		}
	}
	
	/**
	 * Commits transaction.
	 */
	public void commitTransaction() {
		Log4jUtil.debug(logger, "Get transaction from local thread");
		Transaction transaction = transactionThread.get();
		
		if ((transaction != null) 
				&& !transaction.wasCommitted() 
				&& !transaction.wasRolledBack()) {
			Log4jUtil.debug(logger, "Commit transaction");
			transaction.commit();
			transactionThread.set(null);
		}
	}
	
	/**
	 * Gets session provider.
	 * 
	 * @return The session provider.
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets session provider.
	 * 
	 * @param sessionFactory The session provider to set.
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
