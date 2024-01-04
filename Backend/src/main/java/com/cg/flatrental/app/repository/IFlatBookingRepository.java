package com.cg.flatrental.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flatrental.app.entity.FlatBooking;




@Repository
public interface IFlatBookingRepository extends JpaRepository<FlatBooking, Integer>{
	

}
