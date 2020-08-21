package com.me.myapp.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.myapp.DTOApache.DTOCarAccessoryForAddAndUpdate;
import com.me.myapp.DTOApache.DTOCarAccessoryForView;
import com.me.myapp.DTOApache.DTOCarForAddNew;
import com.me.myapp.Entity.Accessory;
import com.me.myapp.Entity.Car;
import com.me.myapp.Entity.CarPK;
import com.me.myapp.Service.ICarService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/cars")
public class CarController {
	@Autowired
	private ICarService carService;

	@PostMapping
	public ResponseEntity<?> AddCar(@RequestBody DTOCarForAddNew dtoCarForAddNew) throws ParseException {
		Car car = dtoCarForAddNew.toEntity();
		carService.AddCar(car);
		return new ResponseEntity<String>("Add Car successfully!", HttpStatus.CREATED);
	}

	@GetMapping(value = "/{licensePlate}_{repairDate}/accessories")
	public ResponseEntity<?> getCarAccessories(@PathVariable(name = "licensePlate") String licensePlate, //
			@PathVariable(name = "repairDate") String repairDate) throws ParseException {
		List<Accessory> accessories = carService
				.getCarAccessory(new CarPK(licensePlate, new SimpleDateFormat("yyyy-MM-dd").parse(repairDate)));
		List<DTOCarAccessoryForView> dtoCarAccessoryForView = new ArrayList<>();
		for (Accessory accessory : accessories) {
			dtoCarAccessoryForView.add(accessory.toDTO());
		}
		return new ResponseEntity<List<DTOCarAccessoryForView>>(dtoCarAccessoryForView, HttpStatus.OK);
	}

	@PostMapping(value = "/{licensePlate}_{repairDate}/accessories")
	public ResponseEntity<?> AddAccessoriesToCar(@PathVariable(name = "licensePlate") String licensePlate, //
			@PathVariable(name = "repairDate") String repairDate, //
			@RequestBody DTOCarAccessoryForAddAndUpdate dtoCarAccessoryForAddAndUpdate) throws ParseException {
		CarPK carPK = new CarPK(licensePlate, new SimpleDateFormat("yyyy-MM-dd").parse(repairDate));
		Car car = carService.getCarById(carPK);
		Accessory accessory = dtoCarAccessoryForAddAndUpdate.toEntity();
		accessory.setCar(car);
		carService.EditOrUpdateCarAccessories(accessory);
		return new ResponseEntity<String>("save car's accessory successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{licensePlate}_{repairDate}/accessories/{id}")
	public ResponseEntity<?> updateCarAccessories(@PathVariable(name = "licensePlate") String licensePlate, //
			@PathVariable(name = "repairDate") String repairDate, //
			@PathVariable(name = "id") int id, //
			@RequestBody DTOCarAccessoryForAddAndUpdate dtoCarAccessoryForAddAndUpdate) throws ParseException {
		CarPK carPK = new CarPK(licensePlate, new SimpleDateFormat("yyyy-MM-dd").parse(repairDate));
		Car car = carService.getCarById(carPK);
		Accessory accessory = dtoCarAccessoryForAddAndUpdate.toEntity();
		accessory.setCar(car);
		accessory.setId(id);
		carService.EditOrUpdateCarAccessories(accessory);
		return new ResponseEntity<String>("update car's accessory successfully!", HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{licensePlate}_{repairDate}/accessories/{id}")
	public ResponseEntity<?> deleteCarAccessories(@PathVariable(name = "licensePlate") String licensePlate, //
			@PathVariable(name = "repairDate") String repairDate, //
			@PathVariable(name = "id") int id) throws ParseException {
		carService.deleteCarAccessories(id);
		return new ResponseEntity<String>("delete car's accessory successfully!", HttpStatus.CREATED);
	}
}
