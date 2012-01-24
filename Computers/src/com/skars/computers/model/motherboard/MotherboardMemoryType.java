package com.skars.computers.model.motherboard;

/**
 * Type of memory that can use in motherboard.
 * 
 * @author skars
 */
public enum MotherboardMemoryType {

	DDR("DDR"), 
	DDR2("DDR2"), 
	DDR3("DDR3"), 
	EMPTY("");
	
	/** Name of type. */
	private String name;
	
	/**
	 * Constructs motherboard memory type.
	 * 
	 * @param name Name of memory type.
	 */
	private MotherboardMemoryType(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of memory type.
	 * 
	 * @return The name of memory type.
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
	public static MotherboardMemoryType getType(String name) {
		MotherboardMemoryType type = EMPTY;
		for (MotherboardMemoryType t : MotherboardMemoryType.values()) {
			if (t.getName().equalsIgnoreCase(name)) {
				type = t;
				break;
			}
		}
		
		return type;
	}
}
