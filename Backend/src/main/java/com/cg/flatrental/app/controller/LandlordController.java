package com.cg.flatrental.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.cg.flatrental.app.entity.Landlord;
import com.cg.flatrental.app.service.implementation.LandlordService;


@RestController
@RequestMapping(value="/landlordCtrl")
@CrossOrigin("*")
public class LandlordController {

	@Autowired
	private LandlordService service;
	static final  Logger LOGGER = LogManager.getLogger(LandlordController.class);
	
	
	
	@PostMapping(value="/addLandlord")
	public ResponseEntity<String> addLandlord(@RequestBody  @Valid Landlord landlord){
		LOGGER.info("----addLandlord() method initialized");
		Landlord value = service.addLandlord(landlord);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("Landlord with ID: "+value.getLandlordId()+" sucessfully created.",HttpStatus.CREATED);
		LOGGER.info(value.getLandlordName()+" Landlord added sucessfully");
		return retvalue;
	}
	
	
	@PutMapping(value= "/updateLandlord/{id}")
	public ResponseEntity<String> updateLandlord(@RequestBody @Valid Landlord landlord, @PathVariable int id){
		LOGGER.info("----updateLandlord() method initialized");
		Landlord value = service.updateLandlord(landlord, id);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("Landlord with ID: "+value.getLandlordId()+" sucessfully updated.",HttpStatus.ACCEPTED);
		LOGGER.info(value.getLandlordName()+" Landlord updated sucessfully");
		return retvalue;
	}
	
	
	@DeleteMapping(value = "/deleteLandlord/{id}")
	public ResponseEntity<Landlord> deleteLandlord(@PathVariable Integer id){
		LOGGER.info("----deleteLandlord() method initialized");
		ResponseEntity<Landlord> retvalue = new ResponseEntity<Landlord>(service.deleteLandlord(id),HttpStatus.OK);
		LOGGER.info("Landlord with id: "+id+" deleted sucessfully");
		return retvalue;
	}
	
	
	@GetMapping(value = "/viewLandlordByID/{id}")
	public ResponseEntity<Landlord> viewLandlord(@PathVariable Integer id) {
		LOGGER.info("----viewLandlordByID() method initialized");
		Landlord value = service.viewLandlord(id);
		ResponseEntity<Landlord> retvalue = new ResponseEntity<Landlord>(value, HttpStatus.OK);
		LOGGER.info(value.getLandlordName()+" Landlord details displayed sucessfully");
		return retvalue;
	}
	
	
	@GetMapping(value = "/viewAllLandlord")
	public ResponseEntity<List<Landlord>> viewAllLandlord() {
		LOGGER.info("----viewAllLandlord() method initialized");
		List<Landlord> list = service.viewAllLandlord();
		ResponseEntity<List<Landlord>> retvalue = new ResponseEntity<List<Landlord>>(list, HttpStatus.OK);
		LOGGER.info("List of landlords displayed sucessfully");
		return retvalue;
		
	}
}
