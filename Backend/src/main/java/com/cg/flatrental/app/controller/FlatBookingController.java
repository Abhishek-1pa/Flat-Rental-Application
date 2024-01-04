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

import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.service.implementation.FlatBookingService;




@RestController
@RequestMapping("/FlatBookingCtrl")
@CrossOrigin("*")
public class FlatBookingController {
	final static Logger logger=LogManager.getLogger(FlatBookingController.class);
	@Autowired
	private FlatBookingService service;
	
	@PostMapping(value="/addFlatBooking")
	public ResponseEntity<String> addFlatBooking(@RequestBody @Valid FlatBooking flatbooking){
		FlatBooking value = service.addFlatBooking(flatbooking);
		ResponseEntity<String> retvalue = new ResponseEntity<>("FlatBooking with Booking No: "+value.getBookingNo()+" sucessfully created.",HttpStatus.CREATED);
		logger.info("addFlatBooking() has executed");
		return retvalue;
	}
	@PutMapping(value= "/updateFlatBooking/{id}")
	public ResponseEntity<String> updateFlatBooking(@RequestBody @Valid FlatBooking flatbooking,@PathVariable Integer id){
		FlatBooking value = service.updateFlatBooking(flatbooking,id);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("FlatBooking with Booking No: "+value.getBookingNo()+" sucessfully updated.",HttpStatus.ACCEPTED);
		logger.info("updateFlatBooking() has executed");
		return retvalue;
	}
	@DeleteMapping(value = "/deleteFlatBooking/{id}")
	public ResponseEntity<String> deleteFlatBooking(@PathVariable Integer id){
		service.deleteFlatBooking(id);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("FlatBooking with Booking No: "+id+" sucessfully deleted.",HttpStatus.OK);
		logger.info("deleteFlatBooking() has executed");
		return retvalue;
	}
	@GetMapping(value = "/viewFlatBookingByID/{id}")
	public ResponseEntity<FlatBooking> viewFlatBooking(@PathVariable Integer id) {
		FlatBooking value = service.viewFlatBooking(id);
		ResponseEntity<FlatBooking> retvalue = new ResponseEntity<FlatBooking>(value, HttpStatus.OK);
		logger.info("viewFlatBooking() has executed");
		return retvalue;
	}
	@GetMapping(value = "/viewAllFlatBooking")
	public ResponseEntity<List<FlatBooking>> viewAllFlatBooking() {
		List<FlatBooking> list = service.viewAllFlatBooking();
		ResponseEntity<List<FlatBooking>> retvalue = new ResponseEntity<List<FlatBooking>>(list, HttpStatus.OK);
		logger.info("view-all-flatBooking URL is opened");
		logger.info("getAllFlatBooking() is initiated");
		logger.info("getAllFlatBooking() has executed");
		return retvalue;
		
	}
}
