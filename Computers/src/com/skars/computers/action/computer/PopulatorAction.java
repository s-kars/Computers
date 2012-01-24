package com.skars.computers.action.computer;

import com.skars.computers.action.BaseAction;
import com.skars.computers.dataservice.computer.IComputerDataService;
import com.skars.computers.model.computer.Computer;
import com.skars.computers.model.computer.ComputerClass;
import com.skars.computers.model.computer.ComputerPlatform;
import com.skars.computers.model.hdd.Hdd;
import com.skars.computers.model.hdd.HddFormfactor;
import com.skars.computers.model.hdd.HddInterface;
import com.skars.computers.model.keyboard.Keyboard;
import com.skars.computers.model.keyboard.KeyboardInterface;
import com.skars.computers.model.keyboard.KeyboardType;
import com.skars.computers.model.monitor.Monitor;
import com.skars.computers.model.monitor.MonitorFormat;
import com.skars.computers.model.monitor.MonitorMatrix;
import com.skars.computers.model.monitor.MonitorResolution;
import com.skars.computers.model.motherboard.Motherboard;
import com.skars.computers.model.motherboard.MotherboardFormfactor;
import com.skars.computers.model.motherboard.MotherboardMemoryType;
import com.skars.computers.model.mouse.Mouse;
import com.skars.computers.model.mouse.MouseInterface;
import com.skars.computers.model.mouse.MouseSensor;
import com.skars.computers.model.mouse.MouseType;
import com.skars.computers.model.processor.Processor;
import com.skars.computers.model.processor.ProcessorSocket;
import com.skars.computers.model.ram.Ram;
import com.skars.computers.model.ram.RamType;
import com.skars.computers.model.video.GraphicsMemory;
import com.skars.computers.model.video.VideoCard;
import com.skars.computers.model.video.VideoCardSocket;

/**
 * This action uses for inserting fake data in database.
 * 
 * @author skars
 */
public class PopulatorAction extends BaseAction {

	/** Identifier for serialization. */
	private static final long serialVersionUID = -5716491048089866503L;

	/** Data service for computers. */
	private IComputerDataService computerDataService;
	
	/**
	 * Constructs action.
	 */
	public PopulatorAction() {
		
	}

	/* 
	 * (non-Javadoc)
	 * @see com.skars.computers.action.BaseAction#processIndex()
	 */
	@Override
	protected void processIndex() throws Exception {
		populate();
	}

	/*
	 * (non-Javadoc)
	 * @see com.skars.computers.action.BaseAction#processExecute()
	 */
	@Override
	protected void processExecute() throws Exception {
		processIndex();
	}
	
	/**
	 * Inserts fake data in database.
	 */
	private void populate() {
		/* Creating processor. */
		Processor processor = new Processor("Intel Core 2 Duo", "Intel");
		processor.setCacheSize(1024);
		processor.setCoresCount(2);
		processor.setFrequency(2.6F);
		processor.setSocket(ProcessorSocket.LGA775);
		
		/* Creating motherboard. */
		Motherboard motherboard = new Motherboard("Gigabyte AF-194", "Gigabyte");
		motherboard.setChipset("NVidia N345");
		motherboard.setFormfactor(MotherboardFormfactor.ATX);
		motherboard.setMemoryType(MotherboardMemoryType.DDR3);
		motherboard.setSocket(ProcessorSocket.LGA775);
		
		/* Creating RAM. */
		Ram ram = new Ram("PC-8000", "Kingston");
		ram.setFrequency(1366);
		ram.setType(RamType.DDR2_SO_DIMM);
		ram.setVolume(2048);
		
		/* Creating video card. */
		VideoCard videoCard = new VideoCard("Palit GForce 440", "Palit");
		videoCard.setMemoryType(GraphicsMemory.GDDR5);
		videoCard.setMemoryVolume(1024);
		videoCard.setProcessorManufacturer("NVidia");
		videoCard.setSocket(VideoCardSocket.PCI_EXPRESS_x16_20);
		
		/* Creating HDD. */
		Hdd hdd = new Hdd("WD 234S", "Western Digital");
		hdd.setConnectionInterface(HddInterface.SATA2);
		hdd.setFormfactor(HddFormfactor.FORM_35);
		hdd.setSpindleSpeed(7200);
		hdd.setVolume(1024 * 1024);
		
		/* Creating monitor. */
		Monitor monitor = new Monitor("FLATRON L1953S", "LG");
		monitor.setDiagonal(19);
		monitor.setFormat(MonitorFormat.FORMAT_4_3);
		monitor.setMatrix(MonitorMatrix.MVA);
		monitor.setResolution(MonitorResolution.RES_1280_1024);
		
		/* Creating keyboard. */
		Keyboard keyboard = new Keyboard("Dialog A23", "Dialog");
		keyboard.setConnectionInterface(KeyboardInterface.PS_2);
		keyboard.setType(KeyboardType.WIRED);
		
		/* Creating mouse. */
		Mouse mouse = new Mouse("A4Tech X7", "A4Tech");
		mouse.setConnectionInterface(MouseInterface.USB);
		mouse.setSensor(MouseSensor.OPTICAL);
		mouse.setType(MouseType.WIRED);
		
		/* Creating personal computer. */
		Computer personalComputer = new Computer("NT34S5", "Samsung");
		personalComputer.setClazz(ComputerClass.PERSONAL);
		personalComputer.setPlatform(ComputerPlatform.LINUX);
		personalComputer.setProcessor(processor);
		personalComputer.setMotherboard(motherboard);
		personalComputer.setRam(ram);
		personalComputer.setVideoCard(videoCard);
		personalComputer.setHdd(hdd);
		personalComputer.setMonitor(monitor);
		personalComputer.setKeyboard(keyboard);
		personalComputer.setMouse(mouse);
		
		/* Creating notebook. */
		Computer notebook = new Computer("A345S34GHB", "Asus");
		notebook.setClazz(ComputerClass.NOTEBOOK);
		notebook.setPlatform(ComputerPlatform.LINUX);
		notebook.setProcessor(processor);
		notebook.setMotherboard(motherboard);
		notebook.setRam(ram);
		notebook.setVideoCard(videoCard);
		notebook.setHdd(hdd);
		notebook.setMonitor(monitor);
		
		/* Save computers. */
		computerDataService.save(personalComputer);
		computerDataService.save(notebook);
	}
	
	/**
	 * Gets data service for computer.
	 * 
	 * @return The data service for computer.
	 */
	public IComputerDataService getComputerDataService() {
		return computerDataService;
	}

	/**
	 * Sets data service for computer.
	 * 
	 * @param computerDataService The data service to set.
	 */
	public void setComputerDataService(IComputerDataService computerDataService) {
		this.computerDataService = computerDataService;
	}
}
