package com.cg.flatrental.app.controller;

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

import com.cg.flatrental.app.entity.Tenant;
import com.cg.flatrental.app.service.implementation.TenantService;

import java.util.List;

import javax.validation.Valid;


@RestController
@RequestMapping("/tenant")
@CrossOrigin("*")
public class TenantController {

	@Autowired
	private TenantService tenantService;
	

	@PostMapping(value = "/addTenant")
	public ResponseEntity<Tenant> addTenant(@RequestBody @Valid Tenant tenant) {
		return new ResponseEntity<>(tenantService.addTenant(tenant), HttpStatus.CREATED);

	}
	
	
	@DeleteMapping(value = "/deletetenant/{tenantId}")
	public ResponseEntity<String> deleteTenant(@PathVariable int tenantId) {
		tenantService.deleteTenant(tenantId);
		ResponseEntity<String> retvalue = new ResponseEntity<String>(
				"Tenant with ID: " + tenantId + " successfully deleted.", HttpStatus.OK);
		return retvalue;
	}
	
	
	@PutMapping(value = "/updateTenant/{tenantId}")
	public ResponseEntity<String> updateTenant(@PathVariable int tenantId, @RequestBody @Valid Tenant tenant) {
		Tenant value = tenantService.updateTenant(tenantId, tenant);
		ResponseEntity<String> retvalue = new ResponseEntity<String>(
				"Tenant with ID: " + value.getTenantId() + " successfully updated.", HttpStatus.ACCEPTED);
		return retvalue;
	}
	

	@GetMapping("/viewAllTenant")
	public ResponseEntity<List<Tenant>> viewAllTenant() {
		List<Tenant> allTenant = tenantService.viewAllTenant();
		ResponseEntity<List<Tenant>> entity = new ResponseEntity<List<Tenant>>(allTenant, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/tenant/{tenantId}")
	public ResponseEntity<Tenant> viewTenant(@PathVariable Integer tenantId) {
		Tenant value = tenantService.viewTenant(tenantId);
		ResponseEntity<Tenant> retvalue = new ResponseEntity<Tenant>( value,HttpStatus.OK);
		return retvalue;
	}
	

	@PatchMapping(value = "/validateTenant/{tenantId}")
	public ResponseEntity<String> validateTenant(@PathVariable int tenantId) {
		if (!tenantService.validateTenant(tenantId)) {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("Tenant ID Not Matched.",
					HttpStatus.NOT_FOUND);
			return retvalue;
		} else {
			ResponseEntity<String> retvalue = new ResponseEntity<String>("Tenant ID Matched.", HttpStatus.ACCEPTED);
			return retvalue;
		}
	}
}
