package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.exception.FlatBookingNotFoundException;


public interface IFlatBookingService {
	public FlatBooking addFlatBooking(FlatBooking flat) ;
	public FlatBooking updateFlatBooking(FlatBooking flat,int id) throws FlatBookingNotFoundException;
	public void deleteFlatBooking(int id) throws FlatBookingNotFoundException;
	public FlatBooking viewFlatBooking(int id) throws FlatBookingNotFoundException;
	public List<FlatBooking> viewAllFlatBooking();
}
