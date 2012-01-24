package com.skars.computers.model.video;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;

/**
 * Video card in computer.
 * 
 * @author skars
 */
@Entity
@Table(name = "VideoCard")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class VideoCard extends Detail {

	/** Type of memory. */
	private GraphicsMemory memoryType;
	
	/** Size of memory in megabytes. */
	private int memoryVolume;
	
	/** Manufacturer of graphics processor. */
	private String processorManufacturer;
	
	/** Socket of card. */
	private VideoCardSocket socket;
	
	/**
	 * Constructs video card.
	 */
	public VideoCard() {
	
	}

	/**
	 * Constructs video card.
	 * 
	 * @param name Name of video card.
	 * @param manufacturer Video card manufacturer.
	 */
	public VideoCard(String name, String manufacturer) {
		super(name, manufacturer);
		setMemoryType(GraphicsMemory.EMPTY);
		setMemoryVolume(0);
		setProcessorManufacturer("");
		setSocket(VideoCardSocket.EMPTY);
	}

	/**
	 * Gets memory type.
	 * 
	 * @return The type of memory.
	 */
	@Enumerated(EnumType.STRING)
	public GraphicsMemory getMemoryType() {
		return memoryType;
	}

	/**
	 * Sets memory type.
	 * 
	 * @param memoryType The type of memory to set.
	 */
	public void setMemoryType(GraphicsMemory memoryType) {
		this.memoryType = memoryType;
	}

	/**
	 * Gets memory volume in megabytes.
	 * 
	 * @return The memory volume in megabytes.
	 */
	@Column
	public int getMemoryVolume() {
		return memoryVolume;
	}

	/**
	 * Sets memory volume in megabytes.
	 * 
	 * @param memoryVolume The memory volume in megabytes to set.
	 */
	public void setMemoryVolume(int memoryVolume) {
		this.memoryVolume = memoryVolume;
	}

	/**
	 * Gets manufacturer of graphics processor.
	 * 
	 * @return The manufacturer of graphics processor.
	 */
	@Column
	public String getProcessorManufacturer() {
		return processorManufacturer;
	}

	/**
	 * Sets manufacturer of graphics processor.
	 * 
	 * @param processorManufacturer The manufacturer to set.
	 */
	public void setProcessorManufacturer(String processorManufacturer) {
		this.processorManufacturer = processorManufacturer;
	}

	/**
	 * Gets socket of card.
	 * 
	 * @return The socket of card.
	 */
	@Enumerated(EnumType.STRING)
	public VideoCardSocket getSocket() {
		return socket;
	}

	/**
	 * Sets socket of card.
	 * 
	 * @param socket The socket to set.
	 */
	public void setSocket(VideoCardSocket socket) {
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
	
		VideoCard objVideoCard = (VideoCard) obj;
		return super.equals(objVideoCard)
				& getMemoryType().equals(objVideoCard.getMemoryType())
				& (getMemoryVolume() == objVideoCard.getMemoryVolume())
				& getProcessorManufacturer().equals(objVideoCard.getProcessorManufacturer())
				& getSocket().equals(objVideoCard.getSocket());
	}
}
