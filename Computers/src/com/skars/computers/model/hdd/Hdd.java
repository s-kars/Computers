package com.skars.computers.model.hdd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;

/**
 * Hard disk drive.
 * 
 * @author skars
 */
@Entity
@Table(name = "Hdd")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Hdd extends Detail {

	/** Formfactor. */
	private HddFormfactor formfactor;
	
	/** Interface for connection. */
	private HddInterface connectionInterface;
	
	/** Speed of spindle in rpm. */
	private int spindleSpeed;
	
	/** Size of disk in megabytes. */
	private int volume;
	
	/**
	 * Constructs HDD.
	 */
	public Hdd() {
	
	}

	/**
	 * Constructs HDD.
	 * 
	 * @param name Name of disk.
	 * @param manufacturer Manufacturer of disk.
	 */
	public Hdd(String name, String manufacturer) {
		super(name, manufacturer);
		setFormfactor(HddFormfactor.EMPTY);
		setConnectionInterface(HddInterface.EMPTY);
		setSpindleSpeed(0);
		setVolume(0);
	}

	/**
	 * Gets formfactor of disk.
	 * 
	 * @return The formfactor.
	 */
	@Enumerated(EnumType.STRING)
	public HddFormfactor getFormfactor() {
		return formfactor;
	}

	/**
	 * Sets formfactor if disk.
	 * 
	 * @param formfactor The formfactor to set.
	 */
	public void setFormfactor(HddFormfactor formfactor) {
		this.formfactor = formfactor;
	}

	/**
	 * Gets interface for connection.
	 * 
	 * @return The interface for connection.
	 */
	@Enumerated(EnumType.STRING)
	public HddInterface getConnectionInterface() {
		return connectionInterface;
	}

	/**
	 * Sets interface for connection.
	 * 
	 * @param connectionInterface The Interface to set.
	 */
	public void setConnectionInterface(HddInterface connectionInterface) {
		this.connectionInterface = connectionInterface;
	}

	/**
	 * Gets speed of spindle. Speed in rpm.
	 * 
	 * @return The speed of spindle.
	 */
	@Column
	public int getSpindleSpeed() {
		return spindleSpeed;
	}

	/**
	 * Sets speed of spindle. Speed in rpm.
	 * 
	 * @param spindleSpeed The speed to set.
	 */
	public void setSpindleSpeed(int spindleSpeed) {
		this.spindleSpeed = spindleSpeed;
	}

	/**
	 * Gets volume of disk. Volume in megabytes.
	 * 
	 * @return The volume of disk in megabytes.
	 */
	@Column
	public int getVolume() {
		return volume;
	}

	/**
	 * Sets volume of disk. Volume in megabytes.
	 * 
	 * @param volume The volume in megabytes to set.
	 */
	public void setVolume(int volume) {
		this.volume = volume;
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
		
		Hdd objHdd = (Hdd) obj;
		return super.equals(objHdd)
				& getFormfactor().equals(objHdd.getFormfactor())
				& getConnectionInterface().equals(objHdd.getConnectionInterface())
				& (getSpindleSpeed() == objHdd.getSpindleSpeed())
				& (getVolume() == objHdd.getVolume());
	}
}
