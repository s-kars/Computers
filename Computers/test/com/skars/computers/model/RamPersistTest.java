package com.skars.computers.model;

import com.skars.computers.model.ram.Ram;
import com.skars.computers.model.ram.RamType;

public class RamPersistTest extends GenericPersistTest<Ram> {

	@Override
	public Ram constructsDetail() {
		Ram ram = new Ram("PC-8000", "Kingston");
		ram.setFrequency(1366);
		ram.setType(RamType.DDR2_SO_DIMM);
		ram.setVolume(2048);
		
		return ram;
	}

	@Override
	public Class<Ram> getDetailClass() {
		return Ram.class;
	}
}
