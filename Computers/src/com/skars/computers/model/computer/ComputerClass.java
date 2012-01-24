package com.skars.computers.model.computer;

/**
 * Class of computer.
 * 
 * @author skars
 */
public enum ComputerClass {

	PERSONAL("Personal"),
	NOTEBOOK("Notebook"),
	EMPTY("");
	
	/** Class name. */
	private String name;
	
	/**
	 * Constructs class of computer.
	 * 
	 * @param name Class name.
	 */
	private ComputerClass(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of class.
	 *
	 * @return The name of class.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets class by name.
	 * 
	 * @param name Name of class.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static ComputerClass getClass(String name) {
		ComputerClass clazz = EMPTY;
		for (ComputerClass c : ComputerClass.values()) {
			if (c.getName().equalsIgnoreCase(name)) {
				clazz = c;
				break;
			}
		}
		
		return clazz;
	}
}
