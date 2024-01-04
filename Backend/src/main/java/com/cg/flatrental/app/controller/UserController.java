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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatrental.app.entity.User;
import com.cg.flatrental.app.service.implementation.UserService;




@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);


	@Autowired
	private UserService service;
	
	
	@PostMapping(value="/addUser")
	public ResponseEntity<String> addUser(@RequestBody @Valid User user){
		LOGGER.info("add-user URL is opened");
		LOGGER.info("addUser() is initiated");
		
		User usr = service.addUser(user);
		ResponseEntity<String> rentity = new ResponseEntity<String>("User with ID: "+usr.getUserId()+" Created Successfully.",HttpStatus.CREATED);
		LOGGER.info("addUser() has executed");
		return rentity;
	}

	
	@PutMapping(value= "/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody @Valid User user){
		LOGGER.info("update-user URL is opened");
		LOGGER.info("updateUser() is initiated");
		
		User usr = service.updateUser(user);
		ResponseEntity<User> retvalue = new ResponseEntity<User>(usr,HttpStatus.ACCEPTED);
		LOGGER.info("updateUser() has executed");
		return retvalue;
	}
	
	
	@PatchMapping(value= "/updatePassword/{newpass}")
	public ResponseEntity<String> updatePassword(@RequestBody @Valid User user,@PathVariable String newpass){
		User usr = service.updatePassword(user, newpass);
		ResponseEntity<String> retvalue = new ResponseEntity<String>("User with ID's password is: "+usr.getUserId()+" sucessfully updated.",HttpStatus.ACCEPTED);
		return retvalue;
	}
	

	@DeleteMapping(value = "/removeUser/{id}")
	public ResponseEntity<String> removeUser(@PathVariable Integer id){
		Boolean value = service.removeUser(id);
		
		ResponseEntity<String> retvalue = new ResponseEntity<String>("User Removed",HttpStatus.OK);

		return retvalue;

	}
	
	
	
	@GetMapping(value = "/viewUserByID/{id}")
	
	public ResponseEntity<User> viewUser(@PathVariable Integer id) {
		User value = service.viewUser(id);
		ResponseEntity<User> retvalue = new ResponseEntity<User>(value, HttpStatus.OK);
		return retvalue;
	}
	
	
	@GetMapping(value = "/viewAllUser")
	public ResponseEntity<List<User>> viewAllUser() {
		List<User> list = service.viewAllUser();
		ResponseEntity<List<User>> retvalue = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		return retvalue;
	}
	
	
	@PatchMapping(value="/validateUser/{userName}/{password}/{userType}")
	public ResponseEntity<String> validateUser(@PathVariable String userName ,@PathVariable String password,@PathVariable String userType){
		if(!service.validateUser(userName,password,userType)) {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("User and Password Not Matched.",HttpStatus.UNAUTHORIZED);
			return retvalue;
		}
		else {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("User and Password Matched.",HttpStatus.ACCEPTED);
			return retvalue;
		}
	}
	
	
}
