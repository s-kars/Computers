package com.skars.computers.model.mouse;

/**
 * Interface of mouse.
 * 
 * @author skars
 */
public enum MouseInterface {

	USB("USB"),
	PS_2("PS/2"),
	EMPTY("");
	
	/** Name of interface. */
	private String name;
	
	/**
	 * Constructs of interface.
	 * 
	 * @param name Interface name.
	 */
	private MouseInterface(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of interface.
	 * 
	 * @return The name of interface.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets interface by name.
	 * 
	 * @param name Name of interface.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static MouseInterface getInterface(String name) {
		MouseInterface mouseInterface = EMPTY;
		for (MouseInterface i : MouseInterface.values()) {
			if (i.getName().equalsIgnoreCase(name)) {
				mouseInterface = i;
				break;
			}
		}
		
		return mouseInterface;
	}
}
