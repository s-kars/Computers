package com.skars.computers.model;

import com.skars.computers.model.monitor.Monitor;
import com.skars.computers.model.monitor.MonitorFormat;
import com.skars.computers.model.monitor.MonitorMatrix;
import com.skars.computers.model.monitor.MonitorResolution;

public class MonitorPersistTest extends GenericPersistTest<Monitor> {

	@Override
	public Monitor constructsDetail() {
		Monitor monitor = new Monitor("FLATRON L1953S", "LG");
		monitor.setDiagonal(19);
		monitor.setFormat(MonitorFormat.FORMAT_4_3);
		monitor.setMatrix(MonitorMatrix.MVA);
		monitor.setResolution(MonitorResolution.RES_1280_1024);
		
		return monitor;
	}

	@Override
	public Class<Monitor> getDetailClass() {
		return Monitor.class;
	}
}
