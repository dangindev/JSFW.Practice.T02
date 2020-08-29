package com.Application.DTO;

import com.Application.Entity.Accessory;

public class DTOAccessoryForAddAndUpdate {
	private String name;
	private int price;
	private String statusDamaged;
	private String repairStatus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatusDamaged() {
		return statusDamaged;
	}
	public void setStatusDamaged(String statusDamaged) {
		this.statusDamaged = statusDamaged;
	}
	public String getRepairStatus() {
		return repairStatus;
	}
	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}
	public DTOAccessoryForAddAndUpdate(String name, int price, String statusDamaged, String repairStatus) {
		this.name = name;
		this.price = price;
		this.statusDamaged = statusDamaged;
		this.repairStatus = repairStatus;
	}
	public DTOAccessoryForAddAndUpdate() {
	}
	public Accessory toEntity() {
		return new Accessory(name, price, repairStatus, statusDamaged);
	}
	
}
