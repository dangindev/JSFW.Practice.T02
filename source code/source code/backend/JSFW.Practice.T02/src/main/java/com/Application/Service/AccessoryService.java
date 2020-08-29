package com.Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Application.Entity.Accessory;
import com.Application.Repository.IAccessoryRepository;

@Service
public class AccessoryService implements IAccessoryService{
	@Autowired IAccessoryRepository accessoryRepository;
	
	public void deleteAccessory(int id) {
		accessoryRepository.deleteById(id);
	}
	public void addOrUpdateAccessory(Accessory accessory) {
		accessoryRepository.save(accessory);
	}
	public Accessory findById(int id) {
		return accessoryRepository.findById(id).get();
	}
}
