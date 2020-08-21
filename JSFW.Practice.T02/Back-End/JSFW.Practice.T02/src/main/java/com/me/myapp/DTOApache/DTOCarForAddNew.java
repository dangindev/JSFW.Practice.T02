package com.me.myapp.DTOApache;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.me.myapp.Entity.Car;
import com.me.myapp.Entity.CarPK;

public class DTOCarForAddNew {
	private String licensePlate;
	private String repairDate;
	private String customerName;
	private String catalogs;
	private String carMaker;

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(String catalogs) {
		this.catalogs = catalogs;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}


	public DTOCarForAddNew(String licensePlate, String repairDate, String customerName, String catalogs,
			String carMaker) {
		super();
		this.licensePlate = licensePlate;
		this.repairDate = repairDate;
		this.customerName = customerName;
		this.catalogs = catalogs;
		this.carMaker = carMaker;
	}

	public Car toEntity() throws ParseException {
		return new Car(new CarPK(licensePlate, new SimpleDateFormat("yyyy-MM-dd").parse(repairDate)), customerName,
				catalogs, carMaker);
	}

}
