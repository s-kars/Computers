package com.skars.computers.action.computer;

import com.skars.computers.action.BaseAction;
import com.skars.computers.dataservice.computer.IComputerDataService;
import com.skars.computers.model.computer.Computer;

/**
 * Shows full information about selected computer.
 * 
 * @author skars
 */
public class ViewComputerAction extends BaseAction {

	/** Identifier for serialization. */
	private static final long serialVersionUID = 42583798212747855L;

	/** Data service for computers. */
	private IComputerDataService computerDataService;
	
	/** Computer. */
	private Computer computer;
	
	/** Identifier of requested computer. */
	private long computerId;
	
	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.action.BaseAction#processIndex()
	 */
	@Override
	protected void processIndex() throws Exception {
		if (getComputerId() <= 0) {
			throw new IllegalArgumentException("Computer identifier [" + getComputerId() + "] can't be less or equals 0");
		}
		
		setComputer(getComputerDataService().get(getComputerId()));
	}

	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.action.BaseAction#processExecute()
	 */
	@Override
	protected void processExecute() throws Exception {
		processIndex();
	}
	
	/**
	 * Gets data service for computer.
	 * 
	 * @return The data service for computer.
	 */
	public IComputerDataService getComputerDataService() {
		return computerDataService;
	}

	/**
	 * Sets data service for computer.
	 * 
	 * @param computerDataService The data service to set.
	 */
	public void setComputerDataService(IComputerDataService computerDataService) {
		this.computerDataService = computerDataService;
	}

	/**
	 * Gets computer.
	 * 
	 * @return The computer.
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * Sets computer.
	 * 
	 * @param computer The computer to set.
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * Gets identifier of requested computer.
	 * 
	 * @return The computer identifier.
	 */
	public long getComputerId() {
		return computerId;
	}

	/**
	 * Sets identifier of requested computer.
	 * 
	 * @param id The identifier to set.
	 */
	public void setComputerId(long id) {
		this.computerId = id;
	}
}
