package com.Application.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.Application.Entity.Car;
import com.Application.Entity.CarPK;

public class DTOCarForAddNew {
	private String licensePlate;
	private String stringRepairDate;
	private String customerName;
	private String catalogs;
	private String carMaker;
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getStringRepairDate() {
		return stringRepairDate;
	}
	public void setStringRepairDate(String stringRepairDate) {
		this.stringRepairDate = stringRepairDate;
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
	public DTOCarForAddNew() {
	}
	public DTOCarForAddNew(String licensePlate, String stringRepairDate, String customerName, String catalogs,
			String carMaker) {
		this.licensePlate = licensePlate;
		this.stringRepairDate = stringRepairDate;
		this.customerName = customerName;
		this.catalogs = catalogs;
		this.carMaker = carMaker;
	}
	public Car toEntity() throws ParseException {
		return new Car(new CarPK(licensePlate, new SimpleDateFormat("yyyy-MM-dd").parse(stringRepairDate)), customerName, catalogs, carMaker);
	}
	

}
