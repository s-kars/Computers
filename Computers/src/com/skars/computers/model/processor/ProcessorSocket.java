package com.skars.computers.model.processor;

/**
 * Socket of processor.
 * 
 * @author skars
 */
public enum ProcessorSocket {

	SOCK_478("478"), 
	SOCK_479("479"), 
	LGA771("LGA771"), 
	LGA775("LGA775"),
	LGA1155("LGA1155"), 
	LGA1156("LGA1156"), 
	LGA1366("LGA1366"), 
	BGA559("BGA559"),
	BGA437("BGA437"), 
	AM2("AM2"), 
	AM2_PLUS("AM2+"), 
	AM3("AM3"), 
	AM3_PLUS("AM3+"),
	EMPTY("");
	
	/** Name of processor socket. */
	private String name;
	
	/**
	 * Constructs processor socket. 
	 * 
	 * @param name Socket name.
	 */
	private ProcessorSocket(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of processor socket.
	 * 
	 * @return The name of socket.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets socket by name.
	 * 
	 * @param name Name of socket.
	 * @return Enumeration constant with specified <code>name</code>.
	 */
	public static ProcessorSocket getSocket(String name) {
		ProcessorSocket socket = EMPTY;
		for (ProcessorSocket s : ProcessorSocket.values()) {
			if (s.getName().equalsIgnoreCase(name)) {
				socket = s;
				break;
			}
		}
		
		return socket;
	}
}
