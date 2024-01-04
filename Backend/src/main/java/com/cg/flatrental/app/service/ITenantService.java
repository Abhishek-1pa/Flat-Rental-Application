package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.Tenant;
import com.cg.flatrental.app.exception.TenantNotFoundException;



public interface ITenantService {
	public Tenant addTenant(Tenant tenant);
	public Tenant updateTenant(int tenantId, Tenant tenant) throws TenantNotFoundException;
	public void deleteTenant(int tenantId) throws TenantNotFoundException;
	public Tenant viewTenant(int id) throws TenantNotFoundException;
	public List<Tenant> viewAllTenant();
	public boolean validateTenant(int tenantId);

}
