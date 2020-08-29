package com.Application.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.Application.DTO.DTOAccessoryForView;


/**
 * The persistent class for the accessory database table.
 * 
 */
@Entity
@Table(name="accessory")
@NamedQuery(name="Accessory.findAll", query="SELECT a FROM Accessory a")
public class Accessory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String name;

	private int price;

	@Column(name="repair_status", length=50)
	private String repairStatus;

	@Column(name="status_damaged", length=50)
	private String statusDamaged;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="license_plate", referencedColumnName="license_plate"),
		@JoinColumn(name="repair_date", referencedColumnName="repair_date")
		})
	private Car car;

	public Accessory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRepairStatus() {
		return this.repairStatus;
	}

	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}

	public String getStatusDamaged() {
		return this.statusDamaged;
	}

	public void setStatusDamaged(String statusDamaged) {
		this.statusDamaged = statusDamaged;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
	public Accessory(String name, int price, String repairStatus, String statusDamaged) {
		this.name = name;
		this.price = price;
		this.repairStatus = repairStatus;
		this.statusDamaged = statusDamaged;
	}

	public DTOAccessoryForView toDTO() {
		return new DTOAccessoryForView(id, name, price, statusDamaged, repairStatus);
	}
	
}