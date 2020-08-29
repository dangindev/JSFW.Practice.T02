package com.Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Application.Entity.Accessory;
import com.Application.Entity.Car;
import com.Application.Entity.CarPK;
import com.Application.Repository.IAccessoryRepository;
import com.Application.Repository.ICarRepository;
@Service
public class CarService implements ICarService{
	@Autowired
	private ICarRepository carRepository;
	@Autowired
	private IAccessoryRepository accessoryRepository;
	
	public void addCar(Car car) {
		carRepository.save(car);
	}
	public Car getCarById(CarPK carPK) {
		return carRepository.findById(carPK).get();
	}
	public List<Accessory> getCarAccessory(CarPK carPK) {
		return getCarById(carPK).getAccessories();
	}
	public void addOrUpdateCarAccessories(Accessory accessory) {
		accessoryRepository.save(accessory);
	}
}
