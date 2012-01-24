package com.skars.computers.model.mouse;

/**
 * Type of mouse.
 * 
 * @author skars
 */
public enum MouseType {
	
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
	private MouseType(String name) {
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
	public static MouseType getType(String name) {
		MouseType type = EMPTY;
		for (MouseType t : MouseType.values()) {
			if (t.getName().equalsIgnoreCase(name)) {
				type = t;
				break;
			}
		}
		
		return type;
	}
}
