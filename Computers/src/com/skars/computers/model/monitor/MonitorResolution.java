package com.skars.computers.model.monitor;

/**
 * Resolution of monitor.
 * 
 * @author skars
 */
public enum MonitorResolution {

	RES_2560_1600("2560x1600"),
	RES_2560_1440("2560x1440"),
	RES_2048_1152("2048x1152"),
	RES_1920_1200("1920x1200"),
	RES_1920_1080("1920x1080"),
	RES_1366_768("1366x768"),
	RES_1280_1024("1280x1024"),
	EMPTY("");
	
	/** Name of resolution. */
	private String name;
	
	/**
	 * Constructs resolution of monitor.
	 * 
	 * @param name Resolution name.
	 */
	private MonitorResolution(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of resolution.
	 * 
	 * @return The name of resolution.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets resolution by name.
	 * 
	 * @param name Name of resolution.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static MonitorResolution getResolution(String name) {
		MonitorResolution resolution = EMPTY;
		for (MonitorResolution r : MonitorResolution.values()) {
			if (r.getName().equalsIgnoreCase(name)) {
				resolution = r;
				break;
			}
		}
		
		return resolution;
	}
}
