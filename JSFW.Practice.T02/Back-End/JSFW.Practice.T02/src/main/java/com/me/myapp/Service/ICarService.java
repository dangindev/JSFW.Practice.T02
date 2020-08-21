package com.me.myapp.Service;

import java.util.List;

import com.me.myapp.Entity.Accessory;
import com.me.myapp.Entity.Car;
import com.me.myapp.Entity.CarPK;

public interface ICarService {
	public void AddCar(Car car);

	public Car getCarById(CarPK carPK);

	public List<Accessory> getCarAccessory(CarPK carPK);

	public void EditOrUpdateCarAccessories(Accessory accessory);

	public void deleteCarAccessories(int id);
}
