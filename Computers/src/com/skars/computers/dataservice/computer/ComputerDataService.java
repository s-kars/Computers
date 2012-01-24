package com.skars.computers.dataservice.computer;

import com.skars.computers.dataservice.GenericDataService;
import com.skars.computers.model.computer.Computer;

/**
 * Implementation of data service for computer.
 * 
 * @author skars
 */
public class ComputerDataService extends GenericDataService<Computer> implements IComputerDataService {

	/**
	 * Constructs data service for computer.
	 */
	public ComputerDataService() {
		super(Computer.class);
	}
}
