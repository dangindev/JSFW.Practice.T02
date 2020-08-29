package com.Application.Service;

import com.Application.Entity.Accessory;

public interface IAccessoryService {
	public void deleteAccessory(int id);
	public void addOrUpdateAccessory(Accessory accessory);
	public Accessory findById(int id);
}
