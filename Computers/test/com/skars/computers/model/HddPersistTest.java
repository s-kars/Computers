package com.skars.computers.model;

import com.skars.computers.model.hdd.Hdd;
import com.skars.computers.model.hdd.HddFormfactor;
import com.skars.computers.model.hdd.HddInterface;

public class HddPersistTest extends GenericPersistTest<Hdd> {

	@Override
	public Hdd constructsDetail() {
		Hdd hdd = new Hdd("WD 234S", "Western Digital");
		hdd.setConnectionInterface(HddInterface.SATA2);
		hdd.setFormfactor(HddFormfactor.FORM_35);
		hdd.setSpindleSpeed(7200);
		hdd.setVolume(1024 * 1024);
		
		return hdd;
	}

	@Override
	public Class<Hdd> getDetailClass() {
		return Hdd.class;
	}
}
