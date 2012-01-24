package com.skars.computers.model.monitor;

/**
 * Format of monitor.
 * 
 * @author skars
 */
public enum MonitorFormat {

	FORMAT_21_9("21:9"),
	FORMAT_16_10("16:10"),
	FORMAT_16_9("16:9"),
	FORMAT_4_3("4:3"),
	FORMAT_5_4("5:4"),
	EMPTY("");

	/** Name of format. */
	private String name;
	
	/**
	 * Constructs format of monitor.
	 * 
	 * @param name Format name.
	 */
	private MonitorFormat(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of format.
	 * 
	 * @return The name of format.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets format by name.
	 * 
	 * @param name Name of format.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static MonitorFormat getFormat(String name) {
		MonitorFormat format = EMPTY;
		for (MonitorFormat f : MonitorFormat.values()) {
			if (f.getName().equalsIgnoreCase(name)) {
				format = f;
				break;
			}
		}
		
		return format;
	}
}
