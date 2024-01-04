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

import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.exception.FlatNotFoundException;
import com.cg.flatrental.app.service.implementation.FlatService;



@RestController      
@RequestMapping("/flat")
@CrossOrigin("*")
public class FlatController {
	private static final Logger logger = LogManager.getLogger(FlatController.class);
	@Autowired
	FlatService flatService;

	
	@PostMapping(value = "/addflat")
	public ResponseEntity<Flat> addFlat(@RequestBody @Valid Flat flat) {
		logger.info("----addFlat() method initialized");

		return new ResponseEntity<>(flatService.addFlat(flat), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/removeflat/{flatId}")
	public ResponseEntity<String> deleteFlat(@PathVariable Integer flatId){
		logger.info("----removeLandlord() method initialized");
        flatService.deleteFlat(flatId);
        ResponseEntity<String> retvalue = new ResponseEntity<String>("Flat with ID: "+flatId+" successfully deleted.",HttpStatus.OK);
        logger.info("Landlord with id: "+flatId+" deleted successfully");
        return retvalue;
    }

	
	@GetMapping(value = "/getallflats")
	public ResponseEntity<List<Flat>> getAllFlats() {
		logger.info("----getAllFlats() method initialized");
		List<Flat> allFlats = flatService.getAllFlats();
		ResponseEntity<List<Flat>> entity = new ResponseEntity<List<Flat>>(allFlats, HttpStatus.OK);
		return entity;
	}
	

	@PutMapping(value = "/updateflat/{flatId}")
	public ResponseEntity<String> updateFlat(@RequestBody Flat flat, @PathVariable Integer flatId){
		logger.info("----updateFlat() method initialized");
		Flat value = flatService.updateFlat(flatId, flat);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("Landlord with ID: "+value.getFlatId()+" successfully updated.",HttpStatus.ACCEPTED);
		logger.info(value.getFlatId()+" Flat updated successfully");
		return retvalue;
	}

	
	@GetMapping(value = "/viewflatbyid/{flatId}")
	public ResponseEntity<Flat> viewFlatById(@PathVariable("flatId") Integer id) throws FlatNotFoundException {
		logger.info("----viewFlatbyId() method initialized");
		return new ResponseEntity<Flat>(flatService.viewFlatById(id), HttpStatus.OK);
	}
}
