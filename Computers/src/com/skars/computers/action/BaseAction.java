package com.skars.computers.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.skars.computers.util.logging.Log4jUtil;

/**
 * Base action for all action in application. This action implements struts-action.
 * 
 * @author skars
 */
public abstract class BaseAction extends ActionSupport {

	/** Identifier for serialization. */
	private static final long serialVersionUID = -1353450896170299003L;

	/** Logger for all events. */
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	
	/** Message with error. */
	private String errorMessage;
	
	/** Type of action for execute. */
	private enum ActionType {
		INDEX, EXECUTE
	}
	
	/**
	 * Constructs action.
	 */
	public BaseAction() {
		setErrorMessage("");
	}

	/**
	 * Prepares data for display on page.
	 * 
	 * @return Returns results of method executing.
	 */
	public String index() {
		return doAction(ActionType.INDEX);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		return doAction(ActionType.EXECUTE);
	}
	
	/**
	 * Executes specified action.
	 * 
	 * @param type Type of action to execute.
	 * @return Returns result of executing.
	 */
	private String doAction(ActionType type) {
		String result = null;
		
		Log4jUtil.debug(logger, "Start process of request");
		try {
			switch (type) {
			case INDEX:
				processIndex();
				break;
				
			case EXECUTE:
				processExecute();
				break;
			}
		
			result = SUCCESS;
			Log4jUtil.debug(logger, "Successfull operation for request");
		} catch (Exception exception) {
			Log4jUtil.debug(logger, "Can't process request", exception);
			
			result = ERROR;
			if ("".equals(getErrorMessage())) {
				setErrorMessage("Can't execute " + getClass().getSimpleName());
			}
		}
		
		return result;
	}
	
	/**
	 * Executes action for prepare data to display in page.
	 * 
	 * @throws Exception If any error occurred.
	 */
	protected abstract void processIndex() throws Exception;
	
	/**
	 * Executes action for process user request.
	 * 
	 * @throws Exception If any error occurred.
	 */
	protected abstract void processExecute() throws Exception;
	
	/**
	 * Gets error message.
	 * 
	 * @return The message with error.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets error message.
	 * 
	 * @param errorMessage The message to set.
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
