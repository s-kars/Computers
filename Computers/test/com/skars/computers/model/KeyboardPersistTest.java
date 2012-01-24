package com.skars.computers.model;

import com.skars.computers.model.keyboard.Keyboard;
import com.skars.computers.model.keyboard.KeyboardInterface;
import com.skars.computers.model.keyboard.KeyboardType;

public class KeyboardPersistTest extends GenericPersistTest<Keyboard> {

	@Override
	public Keyboard constructsDetail() {
		Keyboard keyboard = new Keyboard("Dialog A23", "Dialog");
		keyboard.setConnectionInterface(KeyboardInterface.PS_2);
		keyboard.setType(KeyboardType.WIRED);
		
		return keyboard;
	}

	@Override
	public Class<Keyboard> getDetailClass() {
		return Keyboard.class;
	}
}
