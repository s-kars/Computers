package com.skars.computers.model.hdd;

/**
 * Size of hard disk drive.
 * 
 * @author skars
 */
public enum HddFormfactor {

	FORM_18("1.8\""), 
	FORM_25("2.5\""), 
	FORM_35("3.5\""), 
	EMPTY("");
	
	/** Size of HDD. */
	private String size;
	
	/**
	 * Constructs formfactor of HDD.
	 * 
	 * @param size Size.
	 */
	private HddFormfactor(String size) {
		this.size = size;
	}
	
	/**
	 * Gets formfactor of HDD.
	 * 
	 * @return The formfactor of HDD.
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * Gets form factor by size.
	 * 
	 * @param size Size of hdd.
	 * @return Enumeration constant with specified <code>size</code>.
	 */
	public static HddFormfactor getFormfactor(String size) {
		HddFormfactor formfactor = EMPTY;
		for (HddFormfactor f : HddFormfactor.values()) {
			if (f.getSize().equalsIgnoreCase(size)) {
				formfactor = f;
				break;
			}
		}
		
		return formfactor;
	}
}
