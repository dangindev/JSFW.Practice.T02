package com.Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.DTO.DTOAccessoryForAddAndUpdate;
import com.Application.DTO.DTOAccessoryForView;
import com.Application.Entity.Accessory;
import com.Application.Service.IAccessoryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/accessories")
public class AccessoryController {
	@Autowired
	private IAccessoryService accessoryService;
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccessory(@PathVariable int id) {
		accessoryService.deleteAccessory(id);
		return new ResponseEntity<String>("delete accessory successfully!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccessory(@PathVariable(name = "id") int id,//
			@RequestBody  DTOAccessoryForAddAndUpdate dtoAccessoryForAddAndUpdate){
		Accessory accessory=accessoryService.findById(id);
		accessory.setName(dtoAccessoryForAddAndUpdate.getName());
		accessory.setPrice(dtoAccessoryForAddAndUpdate.getPrice());
		accessory.setRepairStatus(dtoAccessoryForAddAndUpdate.getRepairStatus());
		accessory.setStatusDamaged(dtoAccessoryForAddAndUpdate.getStatusDamaged());
		accessoryService.addOrUpdateAccessory(accessory);
		return new ResponseEntity<String>("update accessory successfully!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccessoryById(@PathVariable int id) {
		DTOAccessoryForView dtoAccessoryForView=accessoryService.findById(id).toDTO();
		return new ResponseEntity<DTOAccessoryForView>(dtoAccessoryForView, HttpStatus.OK);
	}
}
