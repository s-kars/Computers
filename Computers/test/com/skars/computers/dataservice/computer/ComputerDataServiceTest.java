package com.skars.computers.dataservice.computer;

import org.springframework.beans.factory.annotation.Autowired;

import com.skars.computers.dataservice.GenericDataServiceTest;
import com.skars.computers.dataservice.IGenericDataService;
import com.skars.computers.model.ComputerPersistTest;
import com.skars.computers.model.computer.Computer;

public class ComputerDataServiceTest extends GenericDataServiceTest<Computer> {

	@Autowired
	private IComputerDataService computerDataService;
	
	@Override
	public IGenericDataService<Computer> getDataService() {
		return computerDataService;
	}

	@Override
	public Computer constructsDetail() {
		ComputerPersistTest computerTest = new ComputerPersistTest();
		return computerTest.constructsDetail();
	}

	@Override
	public Class<Computer> getDetailClass() {
		return Computer.class;
	}
}
