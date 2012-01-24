package com.skars.computers.model.processor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;

/**
 * Central process unit.
 * 
 * @author skars
 */
@Entity
@Table(name = "Processor")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Processor extends Detail {

	/** Size of cache in kilobytes. */
	private int cacheSize;
	
	/** Count of cores. */
	private int coresCount;
	
	/** Frequency in megahertz. */
	private float frequency;
	
	/** Processor socket. */
	private ProcessorSocket socket;
	
	/**
	 * Constructs processor.
	 */
	public Processor() {
	
	}

	/**
	 * Constructs processor.
	 * 
	 * @param name Processor name.
	 * @param manufacturer Processor manufacturer.
	 */
	public Processor(String name, String manufacturer) {
		super(name, manufacturer);
		setCacheSize(0);
		setCoresCount(0);
		setFrequency(0.0F);
		setSocket(ProcessorSocket.EMPTY);
	}

	/**
	 * Gets size of cache. Size in kilobytes.
	 * 
	 * @return The size of cache.
	 */
	@Column
	public int getCacheSize() {
		return cacheSize;
	}

	/**
	 * Sets size of cache. Size in kilobytes.
	 * 
	 * @param cacheSize The size to set.
	 */
	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	/**
	 * Gets count of cores.
	 * 
	 * @return The cores count.
	 */
	@Column
	public int getCoresCount() {
		return coresCount;
	}

	/**
	 * Sets count of cores.
	 * 
	 * @param coresCount The count of count to set.
	 */
	public void setCoresCount(int coresCount) {
		this.coresCount = coresCount;
	}

	/**
	 * Gets frequency. Frequency in megahertz.
	 * 
	 * @return The frequency.
	 */
	@Column
	public float getFrequency() {
		return frequency;
	}

	/** 
	 * Sets frequency. Frequency in megahertz.
	 * 
	 * @param frequency The frequency to set.
	 */
	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	/**
	 * Gets socket.
	 * 
	 * @return The socket.
	 */
	@Enumerated(EnumType.STRING)
	public ProcessorSocket getSocket() {
		return socket;
	}

	/**
	 * Sets socket.
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
		
		Processor objProcessor = (Processor) obj;
		return super.equals(objProcessor) 
				& (getCacheSize() == objProcessor.getCacheSize())
				& (getCoresCount() == objProcessor.getCoresCount())
				& (getFrequency() == objProcessor.getFrequency())
				& getSocket().equals(objProcessor.getSocket());
	}
}
