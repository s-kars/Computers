package com.skars.computers.action.computer;

import java.util.ArrayList;
import java.util.List;

import com.skars.computers.action.BaseAction;
import com.skars.computers.dataservice.computer.IComputerDataService;
import com.skars.computers.model.computer.Computer;

/**
 * This class defines action for getting all computers.
 * 
 * @author skars
 */
public class GetComputersListAction extends BaseAction {
	
	/** Identifier for serialization. */
	private static final long serialVersionUID = 3985560195070906823L;

	/** Data service for computers. */
	private IComputerDataService computerDataService;
	
	/** List with all computers. */
	private List<Computer> computersList;
	
	/**
	 * Constructs action.
	 */
	public GetComputersListAction() {
		setComputersList(new ArrayList<Computer>());
	}

	/* 
	 * (non-Javadoc)
	 * @see com.skars.computers.action.BaseAction#processIndex()
	 */
	@Override
	protected void processIndex() throws Exception {
		computersList = computerDataService.getAll();
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
	 * Gets list with all computers.
	 * 
	 * @return The list with all computers.
	 */
	public List<Computer> getComputersList() {
		return computersList;
	}

	/**
	 * Sets list with all computers.
	 * 
	 * @param computersList The computers list to set.
	 */
	public void setComputersList(List<Computer> computersList) {
		this.computersList = computersList;
	}
}
