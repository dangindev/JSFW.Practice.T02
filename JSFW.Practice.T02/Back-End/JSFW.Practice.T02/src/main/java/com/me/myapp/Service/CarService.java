package com.me.myapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.myapp.Entity.Accessory;
import com.me.myapp.Entity.Car;
import com.me.myapp.Entity.CarPK;
import com.me.myapp.Repository.IAccessoryRepository;
import com.me.myapp.Repository.ICarRepository;

@Service
public class CarService implements ICarService {
	@Autowired
	private ICarRepository carRepository;
	@Autowired
	private IAccessoryRepository accessoryRepository;

	public void AddCar(Car car) {
		carRepository.save(car);
	}

	public Car getCarById(CarPK carPK) {
		return carRepository.findById(carPK).get();
	}

	public List<Accessory> getCarAccessory(CarPK carPK) {
		return getCarById(carPK).getAccessories();
	}

	public void EditOrUpdateCarAccessories(Accessory accessory) {
		accessoryRepository.save(accessory);
	}

	public void deleteCarAccessories(int id) {
		accessoryRepository.deleteById(id);
	}
}
