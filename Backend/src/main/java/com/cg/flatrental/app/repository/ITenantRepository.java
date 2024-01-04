package com.cg.flatrental.app.repository;

import org.springframework.stereotype.Repository;

import com.cg.flatrental.app.entity.Tenant;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ITenantRepository extends JpaRepository<Tenant, Integer> {

	}
	
