package com.skars.computers.model.motherboard;

/**
 * Size of motherboard.
 * 
 * @author skars
 */
public enum MotherboardFormfactor {

	ATX("ATX"), 
	eATX("eATX"), 
	XL_ATX("XL-ATX"), 
	mATX("mATX"), 
	MINI_ITX("Mini-ITX"),
	EMPTY("");
	
	/** Name of size. */
	private String name;
	
	/**
	 * Constructs formfactor.
	 * 
	 * @param name Name of size.
	 */
	private MotherboardFormfactor(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of size;
	 * 
	 * @return The name of size.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets form factor by name.
	 * 
	 * @param name Name of form factor.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static MotherboardFormfactor getFormfactor(String name) {
		MotherboardFormfactor formfactor = EMPTY;
		for (MotherboardFormfactor f : MotherboardFormfactor.values()) {
			if (f.getName().equalsIgnoreCase(name)) {
				formfactor = f;
				break;
			}
		}
		
		return formfactor;
	}
}
