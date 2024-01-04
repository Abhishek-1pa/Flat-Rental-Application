package com.cg.flatrental.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flatrental.app.entity.Landlord;


@Repository
public interface ILandlordRepository extends JpaRepository<Landlord, Integer>{

}
