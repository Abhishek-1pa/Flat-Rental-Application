package com.cg.flatrental.app.service.implementation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatrental.app.entity.Tenant;
import com.cg.flatrental.app.exception.TenantNotFoundException;
import com.cg.flatrental.app.repository.ITenantRepository;
import com.cg.flatrental.app.service.ITenantService;

import java.util.Optional;


@Service
public class TenantService implements ITenantService {
	
	 private static final Logger logger = LogManager.getLogger(TenantService.class);

	@Autowired
	private ITenantRepository tenantRepository;
	
	
	@Override
	public Tenant addTenant(Tenant tenant) {
		logger.info("Called addTenant() method of TenantService");
		return tenantRepository.save(tenant);
	}
	

	@Override
	public Tenant updateTenant(int tenantId, Tenant tenant) throws TenantNotFoundException {
		logger.info("Called updateTenant() method of TenantService");
		Tenant value = tenantRepository.findById(tenantId)
				.orElseThrow(() -> new TenantNotFoundException("Tenant with ID: " + tenantId + " does not exist."));
		value.setTenantName(tenant.getTenantName());
		value.setAge(tenant.getAge());
		return tenantRepository.save(value);
	}
	

	@Override
	public void deleteTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called deleteTenant() method of TenantService");
		Tenant value = tenantRepository.findById(tenantId)
				.orElseThrow(() -> new TenantNotFoundException("Tenant with id " + tenantId + " does not exist."));
		tenantRepository.delete(value);
	}
	

	@Override
	public Tenant viewTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called viewTenant() method of TenantService");
		return tenantRepository.findById(tenantId).orElseThrow(
				() -> new TenantNotFoundException("Tenant With Given Id :" + tenantId + " Not Available!"));

	}

	@Override
	public List<Tenant> viewAllTenant() {
		logger.info("Called viewAllTenant() method of TenantService");
		return tenantRepository.findAll();
	}
	

	@Override
	public boolean validateTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called validateTenant() method of TenantService");
		boolean flag = false;

		Optional<Tenant> tenant = tenantRepository.findById(tenantId);

		if (tenant == null)
			throw new TenantNotFoundException("Please check Tenant Id");
		else if (tenant.isPresent()) {
			flag = true;
		}

		else
			throw new TenantNotFoundException("Please check Tenant ID");

		return flag;
	}

}
