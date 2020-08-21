package com.me.myapp.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the car database table.
 * 
 */
@Embeddable
public class CarPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "license_plate", unique = true, nullable = false, length = 50)
	private String licensePlate;

	@Temporal(TemporalType.DATE)
	@Column(name = "repair_date", unique = true, nullable = false)
	private Date repairDate;

	public CarPK(String licensePlate, Date repairDate) {
		this.licensePlate = licensePlate;
		this.repairDate = repairDate;
	}

	public CarPK() {
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Date getRepairDate() {
		return this.repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((repairDate == null) ? 0 : repairDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CarPK)) {
			return false;
		}
		CarPK castOther = (CarPK) other;
		return (this.licensePlate == castOther.licensePlate) && this.repairDate.equals(castOther.repairDate);
	}

}