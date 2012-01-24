package com.skars.computers.model.ram;

/**
 * Type of RAM.
 * 
 * @author skars
 */
public enum RamType {

	DDR_DIMM("DDR DIMM"), 
	DDR_SO_DIMM("DDR SO-DIMM"), 
	DDR2_DIMM("DDR2 DIMM"), 
	DDR2_SO_DIMM("DDR2 SO-DIMM"), 
	DDR3_DIMM("DDR3 DIMM"), 
	DDR3_SO_DIMM("DDR3 SO-DIMM"), 
	EMPTY("");
	
	/** Name of type. */
	private String name;
	
	/**
	 * Constructs type of RAM.
	 * 
	 * @param name Name of type.
	 */
	private RamType(String name) {
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
	public static RamType getType(String name) {
		RamType type = EMPTY;
		for (RamType p : RamType.values()) {
			if (p.getName().equalsIgnoreCase(name)) {
				type = p;
				break;
			}
		}
		
		return type;
	}
}
