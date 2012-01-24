package com.skars.computers.model.video;

/**
 * Socket of video card.
 * 
 * @author skars
 */
public enum VideoCardSocket {

	AGP_3_8x("AGP 3.0 8x"), 
	PCI_EXPRESS_x16("PCI-Express x16"),
	PCI_EXPRESS_x16_20("PCI-Express x16 2.0"), 
	PCI_EXPRESS_x16_21("PCI-Express x16 2.1"), 
	EMPTY("");
	
	/** Socket name. */
	private String name;
	
	/**
	 * Constructs socket of video card.
	 * 
	 * @param name Socket name.
	 */
	private VideoCardSocket(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name of socket.
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
	public static VideoCardSocket getSocket(String name) {
		VideoCardSocket socket = EMPTY;
		for (VideoCardSocket s : VideoCardSocket.values()) {
			if (s.getName().equalsIgnoreCase(name)) {
				socket = s;
				break;
			}
		}
		
		return socket;
	}
}
