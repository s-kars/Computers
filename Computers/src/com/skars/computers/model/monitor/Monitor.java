package com.skars.computers.model.monitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.skars.computers.model.Detail;

/**
 * Monitor.
 * 
 * @author skars
 */
@Entity
@Table(name = "Monitor")
@PrimaryKeyJoinColumn(name = "detatil_id")
public class Monitor extends Detail {

	/** Diagonal in inches. */
	private float diagonal;
	
	/** Format of monitor. */
	private MonitorFormat format;
	
	/** Type of matrix. */
	private MonitorMatrix matrix;
	
	/** Monitor resolution. */
	private MonitorResolution resolution;
	
	/**
	 * Constructs monitor.
	 */
	public Monitor() {
	
	}

	/**
	 * Constructs monitor.
	 * 
	 * @param name Monitor name.
	 * @param manufacturer Monitor manufacturer.
	 */
	public Monitor(String name, String manufacturer) {
		super(name, manufacturer);
		setDiagonal(0.0F);
		setFormat(MonitorFormat.EMPTY);
		setMatrix(MonitorMatrix.EMPTY);
		setResolution(MonitorResolution.EMPTY);
	}

	/**
	 * Gets diagonal of monitor. Diagonal in inches.
	 * 
	 * @return The diagonal of monitor. Diagonal in inches.
	 */
	@Column
	public float getDiagonal() {
		return diagonal;
	}

	/**
	 * Sets diagonal of monitor. Diagonal in inches.
	 * 
	 * @param diagonal The diagonal in inches to set.
	 */
	public void setDiagonal(float diagonal) {
		this.diagonal = diagonal;
	}

	/**
	 * Gets monitor format.
	 * 
	 * @return The format of monitor.
	 */
	@Enumerated(EnumType.STRING)
	public MonitorFormat getFormat() {
		return format;
	}

	/**
	 * Sets monitor format.
	 * 
	 * @param format The format to set.
	 */
	public void setFormat(MonitorFormat format) {
		this.format = format;
	}

	/**
	 * Gets monitor matrix type.
	 * 
	 * @return The matrix type.
	 */
	@Enumerated(EnumType.STRING)
	public MonitorMatrix getMatrix() {
		return matrix;
	}

	/**
	 * Sets monitor matrix type.
	 * 
	 * @param matrix The matrix to set.
	 */
	public void setMatrix(MonitorMatrix matrix) {
		this.matrix = matrix;
	}

	/**
	 * Gets monitor resolution.
	 * 
	 * @return The resolution of monitor.
	 */
	@Enumerated(EnumType.STRING)
	public MonitorResolution getResolution() {
		return resolution;
	}

	/**
	 * Sets monitor resolution.
	 * 
	 * @param resolution The resolution to set.
	 */
	public void setResolution(MonitorResolution resolution) {
		this.resolution = resolution;
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
		
		Monitor objMonitor = (Monitor) obj;
		return super.equals(objMonitor)
				& (getDiagonal() == objMonitor.getDiagonal())
				& getMatrix().equals(objMonitor.getMatrix())
				& getFormat().equals(objMonitor.getFormat())
				& getResolution().equals(objMonitor.getResolution());
	}
}
