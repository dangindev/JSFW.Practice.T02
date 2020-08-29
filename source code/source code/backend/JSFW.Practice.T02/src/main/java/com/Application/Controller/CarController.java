package com.Application.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.DTO.DTOAccessoryForAddAndUpdate;
import com.Application.DTO.DTOAccessoryForView;
import com.Application.DTO.DTOCarForAddNew;
import com.Application.Entity.Accessory;
import com.Application.Entity.Car;
import com.Application.Entity.CarPK;
import com.Application.Service.ICarService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/cars")
public class CarController {
	@Autowired
	private ICarService carService;
	
	@PostMapping
	public ResponseEntity<?> AddCar(@RequestBody DTOCarForAddNew dtoCarForAddNew) throws ParseException {
		Car car=dtoCarForAddNew.toEntity();
		carService.addCar(car);
		return new ResponseEntity<String>("Save Car successfully!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/{licensePlate}_{stringRepairDate}/accessories")
	public ResponseEntity<?> getCarAccessories(@PathVariable(name = "licensePlate") String licensePlate, //
			@PathVariable(name = "stringRepairDate") String stringRepairDate) throws ParseException { 
		List<Accessory> accessories=carService.getCarAccessory(new CarPK(licensePlate, new SimpleDateFormat("yyyy-MM-dd").parse(stringRepairDate)));
		List<DTOAccessoryForView> dtoAccessoryForView=new ArrayList<>();
		for (Accessory accessory : accessories) {
			dtoAccessoryForView.add(accessory.toDTO());
		}
		return new ResponseEntity<List<DTOAccessoryForView>>(dtoAccessoryForView, HttpStatus.OK);
	}
	
	@PostMapping(value = "/{licensePlate}_{stringRepairDate}/accessories")
	public ResponseEntity<?> AddAccessoriesToCar(@PathVariable(name = "licensePlate") String licensePlate, //
			@PathVariable(name = "stringRepairDate") String stringRepairDate,//
			@RequestBody  DTOAccessoryForAddAndUpdate dtoAccessoryForAddAndUpdate) throws ParseException {
		CarPK carPK=new CarPK(licensePlate, new SimpleDateFormat("yyyy-MM-dd").parse(stringRepairDate));
		Car car= carService.getCarById(carPK);
		Accessory accessory=dtoAccessoryForAddAndUpdate.toEntity();
		accessory.setCar(car);
		carService.addOrUpdateCarAccessories(accessory);
		return new ResponseEntity<String>("save car's accessory successfully!", HttpStatus.OK);
	}
}
