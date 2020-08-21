package com.me.myapp.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the car database table.
 * 
 */
@Entity
@Table(name = "car")
@NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CarPK id;

	@Column(name = "customer_name", nullable = false, length = 50)
	private String customerName;

	@Column(length = 50)
	private String catalogs;

	@Column(name = "car_maker", length = 50)
	private String carMaker;

	// bi-directional many-to-one association to Accessory
	@OneToMany(mappedBy = "car")
	private List<Accessory> accessories;

	public CarPK getId() {
		return this.id;
	}

	public void setId(CarPK id) {
		this.id = id;
	}

	public String getCarMaker() {
		return this.carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public String getCatalogs() {
		return this.catalogs;
	}

	public void setCatalogs(String catalogs) {
		this.catalogs = catalogs;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Accessory> getAccessories() {
		return this.accessories;
	}

	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}

	public Accessory addAccessory(Accessory accessory) {
		getAccessories().add(accessory);
		accessory.setCar(this);

		return accessory;
	}

	public Accessory removeAccessory(Accessory accessory) {
		getAccessories().remove(accessory);
		accessory.setCar(null);

		return accessory;
	}

	public Car(CarPK id, String customerName, String catalogs, String carMaker) {
		this.id = id;
		this.customerName = customerName;
		this.catalogs = catalogs;
		this.carMaker = carMaker;
	}

	public Car() {
	}

}