package com.skars.computers.model.computer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;
import com.skars.computers.model.hdd.Hdd;
import com.skars.computers.model.keyboard.Keyboard;
import com.skars.computers.model.monitor.Monitor;
import com.skars.computers.model.motherboard.Motherboard;
import com.skars.computers.model.mouse.Mouse;
import com.skars.computers.model.processor.Processor;
import com.skars.computers.model.ram.Ram;
import com.skars.computers.model.video.VideoCard;

/**
 * Computer.
 * 
 * @author skars
 */
@Entity
@Table(name = "Computer")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Computer extends Detail {

	/** Class. */
	private ComputerClass clazz;
	
	/** Platform. */
	private ComputerPlatform platform;
	
	/** Processor. */
	private Processor processor;
	
	/** Motherboard. */
	private Motherboard motherboard;
	
	/** Random access memory. */
	private Ram ram;
	
	/** Video card. */
	private VideoCard videoCard;
	
	/** Hard disk drive. */
	private Hdd hdd;
	
	/** Monitor. */
	private Monitor monitor;
	
	/** Mouse. */
	private Mouse mouse;
	
	/** Keyboard. */
	private Keyboard keyboard;
	
	/**
	 * Constructs computer.
	 */
	public Computer() {
	
	}

	/**
	 * Constructs computer.
	 * 
	 * @param name Computer name.
	 * @param manufacturer Computer manufacturer.
	 */
	public Computer(String name, String manufacturer) {
		super(name, manufacturer);
		setClazz(ComputerClass.EMPTY);
		setPlatform(ComputerPlatform.EMPTY);
		setProcessor(new Processor());
		setMotherboard(new Motherboard());
		setRam(new Ram());
		setVideoCard(new VideoCard());
		setHdd(new Hdd());
		setMonitor(new Monitor());
		setMouse(new Mouse());
		setKeyboard(new Keyboard());
	}

	/**
	 * Gets class of computer.
	 * 
	 * @return The class of computer.
	 */
	@Enumerated(EnumType.STRING)
	public ComputerClass getClazz() {
		return clazz;
	}

	/**
	 * Sets class of computer.
	 * 
	 * @param clazz The class to set.
	 */
	public void setClazz(ComputerClass clazz) {
		this.clazz = clazz;
	}

	/**
	 * Gets computer platform.
	 * 
	 * @return The platform on computer.
	 */
	@Enumerated(EnumType.STRING)
	public ComputerPlatform getPlatform() {
		return platform;
	}

	/**
	 * Sets computer platform.
	 * 
	 * @param platform The platform to set.
	 */
	public void setPlatform(ComputerPlatform platform) {
		this.platform = platform;
	}

	/**
	 * Gets processor.
	 * 
	 * @return The processor.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Processor getProcessor() {
		return processor;
	}

	/**
	 * Sets processor.
	 * 
	 * @param processor The processor to set.
	 */
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	/**
	 * Gets motherboard.
	 * 
	 * @return The motherboard.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Motherboard getMotherboard() {
		return motherboard;
	}

	/**
	 * Sets motherboard.
	 * 
	 * @param motherboard The motherboard to set.
	 */
	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	/**
	 * Gets RAM.
	 * 
	 * @return The RAM.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Ram getRam() {
		return ram;
	}

	/**
	 * Sets RAM.
	 * 
	 * @param ram The RAM to set.
	 */
	public void setRam(Ram ram) {
		this.ram = ram;
	}

	/**
	 * Gets video card.
	 * 
	 * @return The video card.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public VideoCard getVideoCard() {
		return videoCard;
	}

	/**
	 * Sets video card.
	 * 
	 * @param videoCard The video card to set.
	 */
	public void setVideoCard(VideoCard videoCard) {
		this.videoCard = videoCard;
	}

	/**
	 * Gets HDD.
	 * 
	 * @return The HDD.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Hdd getHdd() {
		return hdd;
	}

	/**
	 * Sets HDD.
	 * 
	 * @param hdd The HDD to set.
	 */
	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}

	/**
	 * Gets monitor.
	 * 
	 * @return The monitor.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Monitor getMonitor() {
		return monitor;
	}

	/**
	 * Sets monitor.
	 * 
	 * @param monitor The monitor to set.
	 */
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * Gets mouse.
	 * 
	 * @return The mouse.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Mouse getMouse() {
		return mouse;
	}

	/**
	 * Sets mouse.
	 * 
	 * @param mouse The mouse to set.
	 */
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	/**
	 * Gets keyboard.
	 * 
	 * @return The keyboard.
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Keyboard getKeyboard() {
		return keyboard;
	}

	/**
	 * Sets keyboard.
	 * 
	 * @param keyboard The keyboard to set.
	 */
	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
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
	
		Computer objComputer = (Computer) obj;
		return super.equals(objComputer)
				& getClazz().equals(objComputer.getClazz())
				& getPlatform().equals(objComputer.getPlatform())
				& getProcessor().equals(objComputer.getProcessor())
				& getMotherboard().equals(objComputer.getMotherboard())
				& getRam().equals(objComputer.getRam())
				& getVideoCard().equals(objComputer.getVideoCard())
				& getHdd().equals(objComputer.getHdd())
				& getMonitor().equals(objComputer.getMonitor())
				& getMouse().equals(objComputer.getMouse())
				& getKeyboard().equals(objComputer.getKeyboard());
	}
}
