package com.skars.computers.model.keyboard;

/**
 * Type of keyboard.
 * 
 * @author skars
 */
public enum KeyboardType {

	WIRED("Wired"),
	RADIO("Radio"),
	BLUETOOTH("Bluetooth"),
	EMPTY("");
	
	/** Name of type. */
	private String name;
	
	/**
	 * Constructs of type.
	 * 
	 * @param name Type name.
	 */
	private KeyboardType(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of type.
	 * 
	 * @return The name of type.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets type by name.
	 * 
	 * @param name Name of type.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static KeyboardType getType(String name) {
		KeyboardType type = EMPTY;
		for (KeyboardType t : KeyboardType.values()) {
			if (t.getName().equalsIgnoreCase(name)) {
				type = t;
				break;
			}
		}
		
		return type;
	}
}
