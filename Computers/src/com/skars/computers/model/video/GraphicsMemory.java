package com.skars.computers.model.video;

/**
 * Type of graphics memory.
 * 
 * @author skars
 */
public enum GraphicsMemory {

	GDDR2("GDDR2"), 
	GDDR3("GDDR3"), 
	GDDR4("GDDR4"), 
	GDDR5("GDDR5"), 
	DDR2("DDR2"), 
	DDR3("DDR3"), 
	EMPTY("");
	
	/** Name of memory. */
	private String name;
	
	/**
	 * Constructs type of graphics memory.
	 * 
	 * @param name Name of memory.
	 */
	private GraphicsMemory(String name) {
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
	 * Gets memory by name.
	 * 
	 * @param name Name of memory.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static GraphicsMemory getMemory(String name) {
		GraphicsMemory memory = EMPTY;
		for (GraphicsMemory m : GraphicsMemory.values()) {
			if (m.getName().equalsIgnoreCase(name)) {
				memory = m;
				break;
			}
		}
		
		return memory;
	}
}
