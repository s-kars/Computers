package com.skars.computers.model.keyboard;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;

/**
 * Keyboard in computer.
 * 
 * @author skars
 */
@Entity
@Table(name = "Keyboard")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Keyboard extends Detail {

	/** Interface for connection. */
	private KeyboardInterface connectionInterface;
	
	/** Type of keyboard. */
	private KeyboardType type;
	
	/**
	 * Constructs keyboard.
	 */
	public Keyboard() {
	
	}

	/**
	 * Constructs keyboard.
	 * 
	 * @param name Keyboard name.
	 * @param manufacturer Keyboard manufacturer.
	 */
	public Keyboard(String name, String manufacturer) {
		super(name, manufacturer);
		setConnectionInterface(KeyboardInterface.EMPTY);
		setType(KeyboardType.EMPTY);
	}

	/**
	 * Gets interface for connection.
	 * 
	 * @return The interface for connection.
	 */
	@Enumerated(EnumType.STRING)
	public KeyboardInterface getConnectionInterface() {
		return connectionInterface;
	}

	/**
	 * Sets interface for connection.
	 * 
	 * @param connectionInterface The interface to set.
	 */
	public void setConnectionInterface(KeyboardInterface connectionInterface) {
		this.connectionInterface = connectionInterface;
	}

	/**
	 * Gets type.
	 * 
	 * @return The type.
	 */
	@Enumerated(EnumType.STRING)
	public KeyboardType getType() {
		return type;
	}

	/**
	 * Sets type.
	 * 
	 * @param type The type to set.
	 */
	public void setType(KeyboardType type) {
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
		
		Keyboard objKeyboard = (Keyboard) obj;
		return super.equals(objKeyboard)
				& getConnectionInterface().equals(objKeyboard.getConnectionInterface())
				& getType().equals(objKeyboard.getType());
	}
}
