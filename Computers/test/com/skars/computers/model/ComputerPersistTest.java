package com.skars.computers.model;

import com.skars.computers.model.computer.Computer;
import com.skars.computers.model.computer.ComputerClass;
import com.skars.computers.model.computer.ComputerPlatform;
import com.skars.computers.model.hdd.Hdd;
import com.skars.computers.model.keyboard.Keyboard;
import com.skars.computers.model.monitor.Monitor;
import com.skars.computers.model.motherboard.Motherboard;
import com.skars.computers.model.mouse.Mouse;
import com.skars.computers.model.processor.Processor;
import com.skars.computers.model.ram.Ram;
import com.skars.computers.model.video.VideoCard;

public class ComputerPersistTest extends GenericPersistTest<Computer> {

	private ProcessorPersistTest processorTest = new ProcessorPersistTest();
	private MotherboardPersistTest motherboardTest = new MotherboardPersistTest();
	private RamPersistTest ramTest = new RamPersistTest();
	private VideoCardPersistTest videoCardTest = new VideoCardPersistTest();
	private HddPersistTest hddTest = new HddPersistTest();
	private MonitorPersistTest monitorTest = new MonitorPersistTest();
	private KeyboardPersistTest keyboardTest = new KeyboardPersistTest();
	private MousePersistTest mouseTest = new MousePersistTest();
	
	@Override
	public Computer constructsDetail() {
		Processor processor = processorTest.constructsDetail();
		Motherboard motherboard = motherboardTest.constructsDetail();
		Ram ram = ramTest.constructsDetail();
		VideoCard videoCard = videoCardTest.constructsDetail();
		Hdd hdd = hddTest.constructsDetail();
		Monitor monitor = monitorTest.constructsDetail();
		Keyboard keyboard = keyboardTest.constructsDetail();
		Mouse mouse = mouseTest.constructsDetail();
		
		Computer computer = new Computer("Computer", "NTT");
		computer.setClazz(ComputerClass.PERSONAL);
		computer.setPlatform(ComputerPlatform.LINUX);
		computer.setProcessor(processor);
		computer.setMotherboard(motherboard);
		computer.setRam(ram);
		computer.setVideoCard(videoCard);
		computer.setHdd(hdd);
		computer.setMonitor(monitor);
		computer.setKeyboard(keyboard);
		computer.setMouse(mouse);
		
		return computer;
	}

	@Override
	public Class<Computer> getDetailClass() {
		return Computer.class;
	}
}
