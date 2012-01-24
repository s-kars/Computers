package com.skars.computers.model.motherboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;
import com.skars.computers.model.processor.ProcessorSocket;

/**
 * Motherboard.
 * 
 * @author skars
 */
@Entity
@Table(name = "Motherboard")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Motherboard extends Detail {
 
	/** Chipset in motherboard. */
	private String chipset;
	
	/** Size of motherboard. */
	private MotherboardFormfactor formfactor;
	
	/** Type of memory that can use in motherboard. */
	private MotherboardMemoryType memoryType;
	
	/** Socket for processor. */
	private ProcessorSocket socket;
	
	/**
	 * Constructs motherboard.
	 */
	public Motherboard() {
	
	}

	/**
	 * Constructs motherboard.
	 * 
	 * @param name Name of motherboard.
	 * @param manufacturer Manufacturer of motherboard.
	 */
	public Motherboard(String name, String manufacturer) {
		super(name, manufacturer);
		setChipset("");
		setFormfactor(MotherboardFormfactor.EMPTY);
		setMemoryType(MotherboardMemoryType.EMPTY);
		setSocket(ProcessorSocket.EMPTY);
	}

	/**
	 * Gets chipset name.
	 * 
	 * @return The chipset name.
	 */
	@Column
	public String getChipset() {
		return chipset;
	}

	/**
	 * Sets chipset name.
	 * 
	 * @param chipset The chipset name to set.
	 */
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	/**
	 * Gets size of motherboard.
	 * 
	 * @return The size of motherboard.
	 */
	@Enumerated(EnumType.STRING)
	public MotherboardFormfactor getFormfactor() {
		return formfactor;
	}

	/**
	 * Sets size of motherboard.
	 * 
	 * @param formfactor The size to set.
	 */
	public void setFormfactor(MotherboardFormfactor formfactor) {
		this.formfactor = formfactor;
	}

	/**
	 * Gets memory type that can use in motherboard.
	 * 
	 * @return The memory type.
	 */
	@Enumerated(EnumType.STRING)
	public MotherboardMemoryType getMemoryType() {
		return memoryType;
	}

	/**
	 * Sets memory type that can use in motherboard.
	 * 
	 * @param memoryType The memory type to set.
	 */
	public void setMemoryType(MotherboardMemoryType memoryType) {
		this.memoryType = memoryType;
	}

	/**
	 * Gets socket of processor.
	 * 
	 * @return The socket of processor.
	 */
	@Enumerated(EnumType.STRING)
	public ProcessorSocket getSocket() {
		return socket;
	}

	/**
	 * Sets socket of processor.
	 * 
	 * @param socket The socket to set.
	 */
	public void setSocket(ProcessorSocket socket) {
		this.socket = socket;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (obj.getClass() != getClass()) {
			return false;
		}
		
		Motherboard objMotherboard = (Motherboard) obj;
		return super.equals(objMotherboard) 
				& getChipset().equals(objMotherboard.getChipset())
				& getFormfactor().equals(objMotherboard.getFormfactor())
				& getMemoryType().equals(objMotherboard.getMemoryType())
				& getSocket().equals(objMotherboard.getSocket());
	}
}
