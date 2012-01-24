package com.skars.computers.model.monitor;

/**
 * Type of matrix in monitor.
 * 
 * @author skars
 */
public enum MonitorMatrix {

	TN_FILM("TN+Film"),
	TN_CRYSTALBRITE("TN+Crystalbrite"),
	MVA("MVA"),
	AMVA("AMVA"),
	P_MVA("P-MVA"),
	PVA("PVA"),
	S_PVA("S-PVA"),
	C_PVA("C-PVA"),
	EMPTY("");
	
	/** Name of type. */
	private String name;
	
	/**
	 * Constructs type of matrix in monitor.
	 * 
	 * @param name Name of type.
	 */
	private MonitorMatrix(String name) {
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
	 * Gets matrix by name.
	 * 
	 * @param name Name of matrix.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static MonitorMatrix getMatrix(String name) {
		MonitorMatrix matrix = EMPTY;
		for (MonitorMatrix m : MonitorMatrix.values()) {
			if (m.getName().equalsIgnoreCase(name)) {
				matrix = m;
				break;
			}
		}
		
		return matrix;
	}
}
