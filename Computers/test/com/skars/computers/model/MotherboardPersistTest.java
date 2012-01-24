package com.skars.computers.model;

import com.skars.computers.model.motherboard.Motherboard;
import com.skars.computers.model.motherboard.MotherboardFormfactor;
import com.skars.computers.model.motherboard.MotherboardMemoryType;
import com.skars.computers.model.processor.ProcessorSocket;

public class MotherboardPersistTest extends GenericPersistTest<Motherboard> {

	@Override
	public Motherboard constructsDetail() {
		Motherboard motherboard = new Motherboard("Gigabyte AF-194", "Gigabyte");
		motherboard.setChipset("NVidia N345");
		motherboard.setFormfactor(MotherboardFormfactor.ATX);
		motherboard.setMemoryType(MotherboardMemoryType.DDR3);
		motherboard.setSocket(ProcessorSocket.LGA775);
		
		return motherboard;
	}

	@Override
	public Class<Motherboard> getDetailClass() {
		return Motherboard.class;
	}
}
