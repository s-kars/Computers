package com.skars.computers.model;

import com.skars.computers.model.processor.Processor;
import com.skars.computers.model.processor.ProcessorSocket;

public class ProcessorPersistTest extends GenericPersistTest<Processor> {

	@Override
	public Processor constructsDetail() {
		Processor processor = new Processor("Intel Core 2 Duo", "Intel");
		processor.setCacheSize(1024);
		processor.setCoresCount(2);
		processor.setFrequency(2.6F);
		processor.setSocket(ProcessorSocket.LGA775);
		
		return processor;
	}

	@Override
	public Class<Processor> getDetailClass() {
		return Processor.class;
	}
}
