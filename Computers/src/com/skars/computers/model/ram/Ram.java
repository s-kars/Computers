package com.skars.computers.model.ram;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;

/**
 * Random access memory.
 * 
 * @author skars
 */
@Entity
@Table(name = "Ram")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Ram extends Detail {

	/** Frequency in megahertz. */
	private float frequency;
	
	/** Type of memory. */
	private RamType type;
	
	/** Size of memory in megabytes. */
	private int volume;
	
	/**
	 * Constructs random access memory.
	 */
	public Ram() {
	
	}

	/**
	 * Constructs random access memory.
	 * 
	 * @param name Name of memory.
	 * @param manufacturer Manufacturer of memory.
	 */
	public Ram(String name, String manufacturer) {
		super(name, manufacturer);
		setFrequency(0.0F);
		setType(RamType.EMPTY);
		setVolume(0);
	}

	/**
	 * Gets frequency of memory. Frequency in megahertz.
	 * 
	 * @return The frequency.
	 */
	@Column
	public float getFrequency() {
		return frequency;
	}

	/**
	 * Sets frequency of memory. Frequency in megahertz.
	 * 
	 * @param frequency The frequency to set.
	 */
	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	/**
	 * Gets type of memory.
	 * 
	 * @return The type of memory.
	 */
	@Enumerated(EnumType.STRING)
	public RamType getType() {
		return type;
	}

	/**
	 * Sets type of memory.
	 * 
	 * @param type The type to set.
	 */
	public void setType(RamType type) {
		this.type = type;
	}

	/**
	 * Gets volume of memory. Volume in megabytes.
	 * 
	 * @return The volume of memory.
	 */
	@Column
	public int getVolume() {
		return volume;
	}

	/**
	 * Sets volume of memory. Volume in megabytes.
	 * 
	 * @param volume The volume to set.
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
		
		Ram objRam = (Ram) obj;
		return super.equals(objRam)
				& (getFrequency() == objRam.getFrequency())
				& getType().equals(objRam.getType())
				& (getVolume() == objRam.getVolume());
	}
}
