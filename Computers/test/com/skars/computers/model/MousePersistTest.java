package com.skars.computers.model;

import com.skars.computers.model.mouse.Mouse;
import com.skars.computers.model.mouse.MouseInterface;
import com.skars.computers.model.mouse.MouseSensor;
import com.skars.computers.model.mouse.MouseType;

public class MousePersistTest extends GenericPersistTest<Mouse> {

	@Override
	public Mouse constructsDetail() {
		Mouse mouse = new Mouse("A4Tech X7", "A4Tech");
		mouse.setConnectionInterface(MouseInterface.USB);
		mouse.setSensor(MouseSensor.OPTICAL);
		mouse.setType(MouseType.WIRED);
		
		return mouse;
	}

	@Override
	public Class<Mouse> getDetailClass() {
		return Mouse.class;
	}
}
