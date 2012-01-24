package com.skars.computers.model.mouse;

/**
 * Sensor of mouse.
 * 
 * @author skars
 */
public enum MouseSensor {

	OPTICAL("Optical"),
	LASER("Laser"),
	BLUE_TRACK("BlueTrack"),
	EMPTY("");
	
	/** Name of sensor. */
	private String name;
	
	/**
	 * Constructs sensor.
	 * 
	 * @param name Sensor name.
	 */
	private MouseSensor(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of sensor.
	 * 
	 * @return The name of sensor.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets sensor by name.
	 * 
	 * @param name Name of sensor.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static MouseSensor getSensor(String name) {
		MouseSensor sensor = EMPTY;
		for (MouseSensor s : MouseSensor.values()) {
			if (s.getName().equalsIgnoreCase(name)) {
				sensor = s;
				break;
			}
		}
		
		return sensor;
	}
}
