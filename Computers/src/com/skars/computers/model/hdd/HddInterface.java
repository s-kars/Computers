package com.skars.computers.model.hdd;

/**
 * Interface for connecting of HDD.
 * 
 * @author skars
 */
public enum HddInterface {

	IDE("IDE"), 
	SATA1("SATA 1.0 (1.5Gbps)"), 
	SATA2("SATA 2.0 (3Gbps)"),
	SATA3("SATA 3.0 (6Gbps)"), 
	SCSI("SCSI"), 
	SAS1("SAS 1.0"), 
	SAS2("SAS 2.0"),
	EMPTY("");
	
	/** Interface name. */
	private String name;
	
	/**
	 * Constructs interface of HDD.
	 * 
	 * @param name Interface name.
	 */
	private HddInterface(String name) {
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
	public static HddInterface getInterface(String name) {
		HddInterface hddInterface = EMPTY;
		for (HddInterface i : HddInterface.values()) {
			if (i.getName().equalsIgnoreCase(name)) {
				hddInterface = i;
				break;
			}
		}
		
		return hddInterface;
	}
}
