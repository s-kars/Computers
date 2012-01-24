package com.skars.computers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Super class for all details in computer.
 * 
 * @author skars
 */
@Entity
@Table(name = "Detail")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Detail {

	/** Detail identifier. */
	private long id;
	
	/** Detail name. */
	private String name;
	
	/** Detail manufacturer. */
	private String manufacturer;
	
	/**
	 * Constructs detail. <code>Id</code> sets as 0, 
	 * another all parameters sets as empty strings.
	 */
	public Detail() {
		this("", "");
	}
	
	/**
	 * Constructs detail. <code>Id</code> sets as 0.
	 * 
	 * @param name Name of detail.
	 * @param manufacturer Detail manufacturer.
	 */
	public Detail(String name, String manufacturer) {
		setId(0);
		setName(name);
		setManufacturer(manufacturer);
	}

	/**
	 * Gets detail identifier.
	 * 
	 * @return The detail identifier.
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * Sets detail identifier.
	 * 
	 * @param id The identifier to set.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets detail name.
	 * 
	 * @return The name of detail.
	 */
	@Column
	public String getName() {
		return name;
	}

	/**
	 * Sets detail name.
	 * 
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets detail manufacturer.
	 * 
	 * @return The manufacturer of detail.
	 */
	@Column
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets detail manufacturer.
	 * 
	 * @param manufacturer The manufacturer to set.
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 16 * name.hashCode() + 16 * manufacturer.hashCode();
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
		
		Detail objDetail = (Detail) obj;
		return getName().equals(objDetail.getName()) 
				& getManufacturer().equals(objDetail.getManufacturer());
	}
}
