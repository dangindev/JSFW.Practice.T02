package com.Application.DTO;

public class DTOAccessoryForView {
	private int id;
	private String name;
	private int price;
	private String statusDamaged;
	private String repairStatus;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public DTOAccessoryForView() {
	}
	public DTOAccessoryForView(int id, String name, int price, String statusDamaged, String repairStatus) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.statusDamaged = statusDamaged;
		this.repairStatus = repairStatus;
	}

	
}
