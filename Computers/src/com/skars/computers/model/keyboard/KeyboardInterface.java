package com.skars.computers.model.keyboard;

/**
 * Interface of keyboard.
 * 
 * @author skars
 */
public enum KeyboardInterface {

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
	private KeyboardInterface(String name) {
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
	public static KeyboardInterface getInterface(String name) {
		KeyboardInterface keyboardInterface = EMPTY;
		for (KeyboardInterface i : KeyboardInterface.values()) {
			if (i.getName().equalsIgnoreCase(name)) {
				keyboardInterface = i;
				break;
			}
		}
		
		return keyboardInterface;
	}
}
