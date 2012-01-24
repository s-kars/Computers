package com.skars.computers.model.computer;

/**
 * Platform on computer.
 * 
 * @author skars
 */
public enum ComputerPlatform {

	LINUX("Linux"),
	MAC("Mac OS"),
	WINDOWS("Windows"),
	EMPTY("");
	
	/** Platform name. */
	private String name;
	
	/**
	 * Constructs platform of computer.
	 * 
	 * @param name Platform name.
	 */
	private ComputerPlatform(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of platform.
	 *
	 * @return The name of platform.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets platform by name.
	 * 
	 * @param name Name of platform.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static ComputerPlatform getPlatform(String name) {
		ComputerPlatform platform = EMPTY;
		for (ComputerPlatform p : ComputerPlatform.values()) {
			if (p.getName().equalsIgnoreCase(name)) {
				platform = p;
				break;
			}
		}
		
		return platform;
	}
}
