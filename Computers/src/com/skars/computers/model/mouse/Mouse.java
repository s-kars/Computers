package com.skars.computers.model.mouse;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;

/**
 * Mouse in computer.
 * 
 * @author skars
 */
@Entity
@Table(name = "Mouse")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Mouse extends Detail {

	/** Interface for connection. */
	private MouseInterface connectionInterface;
	
	/** Sensor in mouse. */
	private MouseSensor sensor;
	
	/** Mouse type. */
	private MouseType type;
	
	/**
	 * Constructs mouse.
	 */
	public Mouse() {
	
	}

	/**
	 * Constructs mouse.
	 * 
	 * @param name Mouse name.
	 * @param manufacturer Mouse manufacturer.
	 */
	public Mouse(String name, String manufacturer) {
		super(name, manufacturer);
		setConnectionInterface(MouseInterface.EMPTY);
		setSensor(MouseSensor.EMPTY);
		setType(MouseType.EMPTY);
	}

	/**
	 * Gets interface for connection.
	 * 
	 * @return The interface for connection.
	 */
	@Enumerated(EnumType.STRING)
	public MouseInterface getConnectionInterface() {
		return connectionInterface;
	}

	/**
	 * Sets interface for connection.
	 * 
	 * @param connectionInterface The interface to set.
	 */
	public void setConnectionInterface(MouseInterface connectionInterface) {
		this.connectionInterface = connectionInterface;
	}

	/**
	 * Gets sensor type.
	 * 
	 * @return The sensor type.
	 */
	@Enumerated(EnumType.STRING)
	public MouseSensor getSensor() {
		return sensor;
	}

	/**
	 * Sets type of sensor.
	 * 
	 * @param sensor The sensor type to set.
	 */
	public void setSensor(MouseSensor sensor) {
		this.sensor = sensor;
	}

	/**
	 * Gets type.
	 * 
	 * @return The type.
	 */
	@Enumerated(EnumType.STRING)
	public MouseType getType() {
		return type;
	}

	/**
	 * Sets type.
	 * 
	 * @param type The type to set.
	 */
	public void setType(MouseType type) {
		this.type = type;
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
		
		Mouse objMouse = (Mouse) obj;
		return super.equals(objMouse)
				& getConnectionInterface().equals(objMouse.getConnectionInterface())
				& getSensor().equals(objMouse.getSensor())
				& getType().equals(objMouse.getType());
	}
}
