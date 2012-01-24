package com.skars.computers.action.computer;

import java.util.ArrayList;
import java.util.List;

import com.skars.computers.action.BaseAction;
import com.skars.computers.dataservice.computer.IComputerDataService;
import com.skars.computers.model.computer.Computer;
import com.skars.computers.model.computer.ComputerClass;
import com.skars.computers.model.computer.ComputerPlatform;
import com.skars.computers.model.hdd.HddFormfactor;
import com.skars.computers.model.hdd.HddInterface;
import com.skars.computers.model.keyboard.KeyboardInterface;
import com.skars.computers.model.keyboard.KeyboardType;
import com.skars.computers.model.monitor.MonitorFormat;
import com.skars.computers.model.monitor.MonitorMatrix;
import com.skars.computers.model.monitor.MonitorResolution;
import com.skars.computers.model.motherboard.MotherboardFormfactor;
import com.skars.computers.model.motherboard.MotherboardMemoryType;
import com.skars.computers.model.mouse.MouseInterface;
import com.skars.computers.model.mouse.MouseSensor;
import com.skars.computers.model.mouse.MouseType;
import com.skars.computers.model.processor.ProcessorSocket;
import com.skars.computers.model.ram.RamType;
import com.skars.computers.model.video.GraphicsMemory;
import com.skars.computers.model.video.VideoCardSocket;

/**
 * Saves computer.
 * 
 * @author skars
 */
public class AddEditComputerAction extends BaseAction {

	/** Identifier for serialization. */
	private static final long serialVersionUID = -7526688476105794155L;

	/** Data service for computers. */
	private IComputerDataService computerDataService;
	
	/** Computer. */
	private Computer computer;
	
	/** Identifier of requested computer. */
	private long computerId;
	
	/** List of all available computer classes. */
	private List<String> classesList;
	
	/** Selected computer class. */
	private String clazz;

	/** List of all available computer platforms. */
	private List<String> platformsList;
	
	/** Selected computer platform. */
	private String platform;
	
	/** List of all available processor sockets. */
	private List<String> processorSocketsList;
	
	/** Selected processor socket. */
	private String processorSocket;
	
	/** List of all available form factors of motherboards. */
	private List<String> motherboardFormfactorsList;
	
	/** Selected motherboard form factor. */
	private String motherboardFormfactor;
	
	/** Selected socket of processor on motherboard. */
	private String motherboardProcessorSocket;
	
	/** List of all available types of memory for motherboard. */
	private List<String> motherboardMemoryTypesList;
	
	/** Selected type of memory for motherboard. */
	private String motherboardMemoryType;
	
	/** List of all available types of RAM. */
	private List<String> ramTypesList;
	
	/** Selected RAM type. */
	private String ramType;
	
	/** List of all available graphics memories of video cards. */
	private List<String> videoCardGraphicsMemoriesList;
	
	/** Selected graphics memory for video card. */
	private String videoCardGraphicsMemory;
	
	/** List of all available sockets for video cards. */
	private List<String> videoCardSocketsList;
	
	/** Selected socket for video card. */
	private String videoCardSocket;
	
	/** List of all available form factors for HDD. */
	private List<String> hddFormfactorsList;
	
	/** Selected form factor for HDD. */
	private String hddFormfactor;
	
	/** List of all available connection interfaces for HDD. */
	private List<String> hddConnectionInterfacesList;
	
	/** Selected connection interface for HDD. */
	private String hddConnectionInterface;
	
	/** List of all available formats for monitors. */
	private List<String> monitorFormatsList;
	
	/** Selected format for monitor. */
	private String monitorFormat;
	
	/** List of all available matrixes for monitors. */
	private List<String> monitorMatrixesList;
	
	/** Selected matrix for monitor. */
	private String monitorMatrix;
	
	/** List of all available resolutions for monitors. */
	private List<String> monitorResolutionsList;
	
	/** Selected resolution for monitor. */
	private String monitorResolution;
	
	/** List of all available connection interfaces for mouses. */
	private List<String> mouseConnectionInterfasesList;
	
	/** Selected connection interface for mouse. */
	private String mouseConnectionInterface;
	
	/** List of all available sensors for mouses. */
	private List<String> mouseSensorsList;
	
	/** Selected sensor for mouse. */
	private String mouseSensor;
	
	/** List of all available types for mouses. */
	private List<String> mouseTypesList;
	
	/** Selected type for mouse. */
	private String mouseType;
	
	/** List of all available connection interfaces for keyboards. */
	private List<String> keyboardConnectionInterfasesList;
	
	/** Selected connection interface for keyboard. */
	private String keyboardConnectionInterface;
	
	/** List of all available types for keyboards. */
	private List<String> keyboardTypesList;
	
	/** Selected type for keyboard. */
	private String keyboardType;
	
	/**
	 * Construts action.
	 */
	public AddEditComputerAction() {
		
	}
	
	/* (non-Javadoc)
	 * @see com.skars.computers.action.BaseAction#processIndex()
	 */
	@Override
	protected void processIndex() throws Exception {
		prepareLists();
		
		Computer computer = new Computer();
		if (getComputerId() > 0) {
			computer = computerDataService.get(getComputerId());
			
			setClazz(computer.getClazz().getName());
			setPlatform(computer.getPlatform().getName());
			setProcessorSocket(computer.getProcessor().getSocket().getName());
			setMotherboardFormfactor(computer.getMotherboard().getFormfactor().getName());
			setMotherboardProcessorSocket(computer.getMotherboard().getSocket().getName());
			setMotherboardMemoryType(computer.getMotherboard().getMemoryType().getName());
			setRamType(computer.getRam().getType().getName());
			setVideoCardGraphicsMemory(computer.getVideoCard().getMemoryType().getName());
			setVideoCardSocket(computer.getVideoCard().getSocket().getName());
			setHddFormfactor(computer.getHdd().getFormfactor().getSize());
			setHddConnectionInterface(computer.getHdd().getConnectionInterface().getName());
			setMonitorFormat(computer.getMonitor().getFormat().getName());
			setMonitorMatrix(computer.getMonitor().getMatrix().getName());
			setMonitorResolution(computer.getMonitor().getResolution().getName());
			
			if (ComputerClass.PERSONAL.equals(computer.getClazz())) {
				setMouseConnectionInterface(computer.getMouse().getConnectionInterface().getName());
				setMouseSensor(computer.getMouse().getSensor().getName());
				setMouseType(computer.getMouse().getType().getName());
				setKeyboardConnectionInterface(computer.getKeyboard().getConnectionInterface().getName());
				setKeyboardType(computer.getKeyboard().getType().getName());
			}
		}
		
		setComputer(computer);
	}

	/* (non-Javadoc)
	 * @see com.skars.computers.action.BaseAction#processExecute()
	 */
	@Override
	protected void processExecute() throws Exception {
		getComputer().setClazz(ComputerClass.getClass(clazz));
		getComputer().setPlatform(ComputerPlatform.getPlatform(platform));
		getComputer().getProcessor().setSocket(ProcessorSocket.getSocket(processorSocket));
		getComputer().getMotherboard().setFormfactor(MotherboardFormfactor.getFormfactor(motherboardFormfactor));
		getComputer().getMotherboard().setSocket(ProcessorSocket.getSocket(motherboardProcessorSocket));
		getComputer().getMotherboard().setMemoryType(MotherboardMemoryType.getType(motherboardMemoryType));
		getComputer().getRam().setType(RamType.getType(ramType));
		getComputer().getVideoCard().setMemoryType(GraphicsMemory.getMemory(videoCardGraphicsMemory));
		getComputer().getVideoCard().setSocket(VideoCardSocket.getSocket(videoCardSocket));
		getComputer().getHdd().setFormfactor(HddFormfactor.getFormfactor(hddFormfactor));
		getComputer().getHdd().setConnectionInterface(HddInterface.getInterface(hddConnectionInterface));
		getComputer().getMonitor().setFormat(MonitorFormat.getFormat(monitorFormat));
		getComputer().getMonitor().setMatrix(MonitorMatrix.getMatrix(monitorMatrix));
		getComputer().getMonitor().setResolution(MonitorResolution.getResolution(monitorResolution));
		
		if (ComputerClass.PERSONAL.equals(getComputer().getClazz())) {
			getComputer().getMouse().setConnectionInterface(MouseInterface.getInterface(mouseConnectionInterface));
			getComputer().getMouse().setSensor(MouseSensor.getSensor(mouseSensor));
			getComputer().getMouse().setType(MouseType.getType(mouseType));
			getComputer().getKeyboard().setConnectionInterface(KeyboardInterface.getInterface(keyboardConnectionInterface));
			getComputer().getKeyboard().setType(KeyboardType.getType(keyboardType));
		}
		
		computerDataService.save(getComputer());
	}
	
	/**
	 * Creates all lists and fill it values.
	 */
	private void prepareLists() {
		/* Class. */
		classesList = new ArrayList<String>();
		for (ComputerClass c : ComputerClass.values()) {
			if (!c.equals(ComputerClass.EMPTY)) {
				classesList.add(c.getName());
			}
		}
		
		/* Platform. */
		platformsList = new ArrayList<String>();
		for (ComputerPlatform p : ComputerPlatform.values()) {
			if (!p.equals(ComputerPlatform.EMPTY)) {
				platformsList.add(p.getName());
			}
		}
		
		/* Processor socket. */
		processorSocketsList = new ArrayList<String>();
		for (ProcessorSocket s : ProcessorSocket.values()) {
			if (!s.equals(ProcessorSocket.EMPTY)) {
				processorSocketsList.add(s.getName());
			}
		}
		
		/* Motherboard form factor. */
		motherboardFormfactorsList = new ArrayList<String>();
		for (MotherboardFormfactor f : MotherboardFormfactor.values()) {
			if (!f.equals(MotherboardFormfactor.EMPTY)) {
				motherboardFormfactorsList.add(f.getName());
			}
		}
		
		/* Motherboard memory type. */
		motherboardMemoryTypesList = new ArrayList<String>();
		for (MotherboardMemoryType t : MotherboardMemoryType.values()) { 
			if (!t.equals(MotherboardMemoryType.EMPTY)) {
				motherboardMemoryTypesList.add(t.getName());
			}
		}
		
		/* RAM type. */
		ramTypesList = new ArrayList<String>();
		for (RamType t : RamType.values()) {
			if (!t.equals(RamType.EMPTY)) {
				ramTypesList.add(t.getName());
			}
		}
		
		/* Graphics memory. */
		videoCardGraphicsMemoriesList = new ArrayList<String>();
		for (GraphicsMemory m : GraphicsMemory.values()) {
			if (!m.equals(GraphicsMemory.EMPTY)) {
				videoCardGraphicsMemoriesList.add(m.getName());
			}
		}
		
		/* Video card socket. */
		videoCardSocketsList = new ArrayList<String>();
		for (VideoCardSocket s : VideoCardSocket.values()) {
			if (!s.equals(VideoCardSocket.EMPTY)) {
				videoCardSocketsList.add(s.getName());
			}
		}
		
		/* HDD form factor. */
		hddFormfactorsList = new ArrayList<String>();
		for (HddFormfactor f : HddFormfactor.values()) {
			if (!f.equals(HddFormfactor.EMPTY)) {
				hddFormfactorsList.add(f.getSize());
			}
		}
		
		/* HDD connection interface. */
		hddConnectionInterfacesList = new ArrayList<String>();
		for (HddInterface i : HddInterface.values()) {
			if (!i.equals(HddInterface.EMPTY)) {
				hddConnectionInterfacesList.add(i.getName());
			}
		}
		
		/* Monitor format. */
		monitorFormatsList = new ArrayList<String>();
		for (MonitorFormat f : MonitorFormat.values()) {
			if (!f.equals(MonitorFormat.EMPTY)) {
				monitorFormatsList.add(f.getName());
			}
		}
		
		/* Monitor matrix. */
		monitorMatrixesList = new ArrayList<String>();
		for (MonitorMatrix m : MonitorMatrix.values()) {
			if (!m.equals(MonitorMatrix.EMPTY)) {
				monitorMatrixesList.add(m.getName());
			}
		}
		
		/* Monitor resolution. */
		monitorResolutionsList = new ArrayList<String>();
		for (MonitorResolution r : MonitorResolution.values()) {
			if (!r.equals(MonitorResolution.EMPTY)) {
				monitorResolutionsList.add(r.getName());
			}
		}
		
		/* Mouse connection interface. */
		mouseConnectionInterfasesList = new ArrayList<String>();
		for (MouseInterface i : MouseInterface.values()) {
			if (!i.equals(MouseInterface.EMPTY)) {
				mouseConnectionInterfasesList.add(i.getName());
			}
		}
		
		/* Mouse sensor. */
		mouseSensorsList = new ArrayList<String>();
		for (MouseSensor s : MouseSensor.values()) {
			if (!s.equals(MouseSensor.EMPTY)) {
				mouseSensorsList.add(s.getName());
			}
		}
		
		/* Mouse type. */
		mouseTypesList = new ArrayList<String>();
		for (MouseType t : MouseType.values()) {
			if (!t.equals(MouseType.EMPTY)) {
				mouseTypesList.add(t.getName());
			}
		}
		
		/* Keyboard connection interface. */
		keyboardConnectionInterfasesList = new ArrayList<String>();
		for (KeyboardInterface i : KeyboardInterface.values()) {
			if (!i.equals(KeyboardInterface.EMPTY)) {
				keyboardConnectionInterfasesList.add(i.getName());
			}
		}
		
		/* Keyboard type. */
		keyboardTypesList = new ArrayList<String>();
		for (KeyboardType t : KeyboardType.values()) {
			if (!t.equals(KeyboardType.EMPTY)) {
				keyboardTypesList.add(t.getName());
			}
		}
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

	/**
	 * Gets computer.
	 * 
	 * @return The computer.
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * Sets computer.
	 * 
	 * @param computer The computer to set.
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * Gets identifier of requested computer.
	 * 
	 * @return The computer identifier.
	 */
	public long getComputerId() {
		return computerId;
	}

	/**
	 * Sets identifier of requested computer.
	 * 
	 * @param id The identifier to set.
	 */
	public void setComputerId(long id) {
		this.computerId = id;
	}

	/**
	 * @return the classesList
	 */
	public List<String> getClassesList() {
		return classesList;
	}

	/**
	 * @param classesList the classesList to set
	 */
	public void setClassesList(List<String> classesList) {
		this.classesList = classesList;
	}

	/**
	 * @return the clazz
	 */
	public String getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	/**
	 * @return the platformList
	 */
	public List<String> getPlatformsList() {
		return platformsList;
	}

	/**
	 * @param platformsList the platformList to set
	 */
	public void setPlatformsList(List<String> platformsList) {
		this.platformsList = platformsList;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the processorSocketsList
	 */
	public List<String> getProcessorSocketsList() {
		return processorSocketsList;
	}

	/**
	 * @param processorSocketsList the processorSocketsList to set
	 */
	public void setProcessorSocketsList(List<String> processorSocketsList) {
		this.processorSocketsList = processorSocketsList;
	}

	/**
	 * @return the processorSocket
	 */
	public String getProcessorSocket() {
		return processorSocket;
	}

	/**
	 * @param processorSocket the processorSocket to set
	 */
	public void setProcessorSocket(String processorSocket) {
		this.processorSocket = processorSocket;
	}

	/**
	 * @return the motherboardFormfactorsList
	 */
	public List<String> getMotherboardFormfactorsList() {
		return motherboardFormfactorsList;
	}

	/**
	 * @param motherboardFormfactorsList the motherboardFormfactorsList to set
	 */
	public void setMotherboardFormfactorsList(
			List<String> motherboardFormfactorsList) {
		this.motherboardFormfactorsList = motherboardFormfactorsList;
	}

	/**
	 * @return the motherboardFormfactor
	 */
	public String getMotherboardFormfactor() {
		return motherboardFormfactor;
	}

	/**
	 * @param motherboardFormfactor the motherboardFormfactor to set
	 */
	public void setMotherboardFormfactor(String motherboardFormfactor) {
		this.motherboardFormfactor = motherboardFormfactor;
	}

	/**
	 * @return the motherboardProcessorSocket
	 */
	public String getMotherboardProcessorSocket() {
		return motherboardProcessorSocket;
	}

	/**
	 * @param motherboardProcessorSocket the motherboardProcessorSocket to set
	 */
	public void setMotherboardProcessorSocket(String motherboardProcessorSocket) {
		this.motherboardProcessorSocket = motherboardProcessorSocket;
	}

	/**
	 * @return the motherboardMemoryTypesList
	 */
	public List<String> getMotherboardMemoryTypesList() {
		return motherboardMemoryTypesList;
	}

	/**
	 * @param motherboardMemoryTypesList the motherboardMemoryTypesList to set
	 */
	public void setMotherboardMemoryTypesList(
			List<String> motherboardMemoryTypesList) {
		this.motherboardMemoryTypesList = motherboardMemoryTypesList;
	}

	/**
	 * @return the motherboardMemoryType
	 */
	public String getMotherboardMemoryType() {
		return motherboardMemoryType;
	}

	/**
	 * @param motherboardMemoryType the motherboardMemoryType to set
	 */
	public void setMotherboardMemoryType(String motherboardMemoryType) {
		this.motherboardMemoryType = motherboardMemoryType;
	}

	/**
	 * @return the ramTypesList
	 */
	public List<String> getRamTypesList() {
		return ramTypesList;
	}

	/**
	 * @param ramTypesList the ramTypesList to set
	 */
	public void setRamTypesList(List<String> ramTypesList) {
		this.ramTypesList = ramTypesList;
	}

	/**
	 * @return the ramType
	 */
	public String getRamType() {
		return ramType;
	}

	/**
	 * @param ramType the ramType to set
	 */
	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	/**
	 * @return the videoCardGraphicsMemoriesList
	 */
	public List<String> getVideoCardGraphicsMemoriesList() {
		return videoCardGraphicsMemoriesList;
	}

	/**
	 * @param videoCardGraphicsMemoriesList the videoCardGraphicsMemoriesList to set
	 */
	public void setVideoCardGraphicsMemoriesList(
			List<String> videoCardGraphicsMemoriesList) {
		this.videoCardGraphicsMemoriesList = videoCardGraphicsMemoriesList;
	}

	/**
	 * @return the videoCardGraphicsMemory
	 */
	public String getVideoCardGraphicsMemory() {
		return videoCardGraphicsMemory;
	}

	/**
	 * @param videoCardGraphicsMemory the videoCardGraphicsMemory to set
	 */
	public void setVideoCardGraphicsMemory(String videoCardGraphicsMemory) {
		this.videoCardGraphicsMemory = videoCardGraphicsMemory;
	}

	/**
	 * @return the videoCardSocketsList
	 */
	public List<String> getVideoCardSocketsList() {
		return videoCardSocketsList;
	}

	/**
	 * @param videoCardSocketsList the videoCardSocketsList to set
	 */
	public void setVideoCardSocketsList(List<String> videoCardSocketsList) {
		this.videoCardSocketsList = videoCardSocketsList;
	}

	/**
	 * @return the videoCardSocket
	 */
	public String getVideoCardSocket() {
		return videoCardSocket;
	}

	/**
	 * @param videoCardSocket the videoCardSocket to set
	 */
	public void setVideoCardSocket(String videoCardSocket) {
		this.videoCardSocket = videoCardSocket;
	}

	/**
	 * @return the hddFormfactorsList
	 */
	public List<String> getHddFormfactorsList() {
		return hddFormfactorsList;
	}

	/**
	 * @param hddFormfactorsList the hddFormfactorsList to set
	 */
	public void setHddFormfactorsList(List<String> hddFormfactorsList) {
		this.hddFormfactorsList = hddFormfactorsList;
	}

	/**
	 * @return the hddFormfactor
	 */
	public String getHddFormfactor() {
		return hddFormfactor;
	}

	/**
	 * @param hddFormfactor the hddFormfactor to set
	 */
	public void setHddFormfactor(String hddFormfactor) {
		this.hddFormfactor = hddFormfactor;
	}

	/**
	 * @return the hddConnectionInterfacesList
	 */
	public List<String> getHddConnectionInterfacesList() {
		return hddConnectionInterfacesList;
	}

	/**
	 * @param hddConnectionInterfacesList the hddConnectionInterfacesList to set
	 */
	public void setHddConnectionInterfacesList(
			List<String> hddConnectionInterfacesList) {
		this.hddConnectionInterfacesList = hddConnectionInterfacesList;
	}

	/**
	 * @return the hddConnectionInterface
	 */
	public String getHddConnectionInterface() {
		return hddConnectionInterface;
	}

	/**
	 * @param hddConnectionInterface the hddConnectionInterface to set
	 */
	public void setHddConnectionInterface(String hddConnectionInterface) {
		this.hddConnectionInterface = hddConnectionInterface;
	}

	/**
	 * @return the monitorFormatsList
	 */
	public List<String> getMonitorFormatsList() {
		return monitorFormatsList;
	}

	/**
	 * @param monitorFormatsList the monitorFormatsList to set
	 */
	public void setMonitorFormatsList(List<String> monitorFormatsList) {
		this.monitorFormatsList = monitorFormatsList;
	}

	/**
	 * @return the monitorFormat
	 */
	public String getMonitorFormat() {
		return monitorFormat;
	}

	/**
	 * @param monitorFormat the monitorFormat to set
	 */
	public void setMonitorFormat(String monitorFormat) {
		this.monitorFormat = monitorFormat;
	}

	/**
	 * @return the monitorMatrixesList
	 */
	public List<String> getMonitorMatrixesList() {
		return monitorMatrixesList;
	}

	/**
	 * @param monitorMatrixesList the monitorMatrixesList to set
	 */
	public void setMonitorMatrixesList(List<String> monitorMatrixesList) {
		this.monitorMatrixesList = monitorMatrixesList;
	}

	/**
	 * @return the monitorMatrix
	 */
	public String getMonitorMatrix() {
		return monitorMatrix;
	}

	/**
	 * @param monitorMatrix the monitorMatrix to set
	 */
	public void setMonitorMatrix(String monitorMatrix) {
		this.monitorMatrix = monitorMatrix;
	}

	/**
	 * @return the monitorResolutionsList
	 */
	public List<String> getMonitorResolutionsList() {
		return monitorResolutionsList;
	}

	/**
	 * @param monitorResolutionsList the monitorResolutionsList to set
	 */
	public void setMonitorResolutionsList(List<String> monitorResolutionsList) {
		this.monitorResolutionsList = monitorResolutionsList;
	}

	/**
	 * @return the monitorResolution
	 */
	public String getMonitorResolution() {
		return monitorResolution;
	}

	/**
	 * @param monitorResolution the monitorResolution to set
	 */
	public void setMonitorResolution(String monitorResolution) {
		this.monitorResolution = monitorResolution;
	}

	/**
	 * @return the mouseConnectionInterfasesList
	 */
	public List<String> getMouseConnectionInterfasesList() {
		return mouseConnectionInterfasesList;
	}

	/**
	 * @param mouseConnectionInterfasesList the mouseConnectionInterfasesList to set
	 */
	public void setMouseConnectionInterfasesList(
			List<String> mouseConnectionInterfasesList) {
		this.mouseConnectionInterfasesList = mouseConnectionInterfasesList;
	}

	/**
	 * @return the mouseConnectionInterface
	 */
	public String getMouseConnectionInterface() {
		return mouseConnectionInterface;
	}

	/**
	 * @param mouseConnectionInterface the mouseConnectionInterface to set
	 */
	public void setMouseConnectionInterface(String mouseConnectionInterface) {
		this.mouseConnectionInterface = mouseConnectionInterface;
	}

	/**
	 * @return the mouseSensorsList
	 */
	public List<String> getMouseSensorsList() {
		return mouseSensorsList;
	}

	/**
	 * @param mouseSensorsList the mouseSensorsList to set
	 */
	public void setMouseSensorsList(List<String> mouseSensorsList) {
		this.mouseSensorsList = mouseSensorsList;
	}

	/**
	 * @return the mouseSensor
	 */
	public String getMouseSensor() {
		return mouseSensor;
	}

	/**
	 * @param mouseSensor the mouseSensor to set
	 */
	public void setMouseSensor(String mouseSensor) {
		this.mouseSensor = mouseSensor;
	}

	/**
	 * @return the mouseTypesList
	 */
	public List<String> getMouseTypesList() {
		return mouseTypesList;
	}

	/**
	 * @param mouseTypesList the mouseTypesList to set
	 */
	public void setMouseTypesList(List<String> mouseTypesList) {
		this.mouseTypesList = mouseTypesList;
	}

	/**
	 * @return the mouseType
	 */
	public String getMouseType() {
		return mouseType;
	}

	/**
	 * @param mouseType the mouseType to set
	 */
	public void setMouseType(String mouseType) {
		this.mouseType = mouseType;
	}

	/**
	 * @return the keyboardConnectionInterfasesList
	 */
	public List<String> getKeyboardConnectionInterfasesList() {
		return keyboardConnectionInterfasesList;
	}

	/**
	 * @param keyboardConnectionInterfasesList the keyboardConnectionInterfasesList to set
	 */
	public void setKeyboardConnectionInterfasesList(
			List<String> keyboardConnectionInterfasesList) {
		this.keyboardConnectionInterfasesList = keyboardConnectionInterfasesList;
	}

	/**
	 * @return the keyboardConnectionInterface
	 */
	public String getKeyboardConnectionInterface() {
		return keyboardConnectionInterface;
	}

	/**
	 * @param keyboardConnectionInterface the keyboardConnectionInterface to set
	 */
	public void setKeyboardConnectionInterface(String keyboardConnectionInterface) {
		this.keyboardConnectionInterface = keyboardConnectionInterface;
	}

	/**
	 * @return the keyboardTypesList
	 */
	public List<String> getKeyboardTypesList() {
		return keyboardTypesList;
	}

	/**
	 * @param keyboardTypesList the keyboardTypesList to set
	 */
	public void setKeyboardTypesList(List<String> keyboardTypesList) {
		this.keyboardTypesList = keyboardTypesList;
	}

	/**
	 * @return the keyboardType
	 */
	public String getKeyboardType() {
		return keyboardType;
	}

	/**
	 * @param keyboardType the keyboardType to set
	 */
	public void setKeyboardType(String keyboardType) {
		this.keyboardType = keyboardType;
	}
}
