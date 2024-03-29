package com.cg.flatrental.app.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.exception.FlatBookingNotFoundException;
import com.cg.flatrental.app.exception.TenantNotFoundException;
import com.cg.flatrental.app.repository.IFlatBookingRepository;
import com.cg.flatrental.app.service.IFlatBookingService;



@Service
public class FlatBookingService implements IFlatBookingService{
	final static Logger logger=LogManager.getLogger(FlatBookingService.class);
	static String validationSuccessful = "Validation Successful";
	
	@Autowired
	private IFlatBookingRepository repo;
	
	@Override
	public FlatBooking addFlatBooking(FlatBooking flat) {
		validateFlatBooking(flat);
		FlatBooking fb=repo.save(flat);
		return fb;
	}
	/*
	 * MethodName  : updateFlatBooking
	 * Description : Method will update existing FlatBooking details
	 * Input Arguments : FlatBooking Object, FlatBooking Id(Primary key) int 
	 * Return Value : FlatBooking Object 
	 * Exception : FlatBookingNotFoundException
	 */
	@Override
	public FlatBooking updateFlatBooking(FlatBooking flat,int id) throws FlatBookingNotFoundException {
		FlatBooking value=repo.findById(id).orElseThrow(()->new FlatBookingNotFoundException("FlatBooking with booking no :"+id+"does not exist"));
		value.setFlat(flat.getFlat());
		value.setTenantId(flat.getTenantId());
		value.setBookingFromDate(flat.getBookingFromDate());
		value.setBookingToDate(flat.getBookingToDate());
		return repo.save(value);
	}
	@Override
	public void deleteFlatBooking(int id) throws FlatBookingNotFoundException {
		FlatBooking value=repo.findById(id).orElseThrow(()->new FlatBookingNotFoundException("FlatBooking with booking no:"+id+"does not exist"));
		repo.delete(value);
	}
	@Override
	public FlatBooking viewFlatBooking(int id) throws FlatBookingNotFoundException {
		return repo.findById(id).orElseThrow(()->new FlatBookingNotFoundException("FlatBooking with booking no "+id+" does not exist."));
		
	}
	
	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> allFlatBooking=repo.findAll();
		System.out.println("Data From DB :");
		allFlatBooking.forEach(FlatBooking->{
			System.out.println("Tenant Id :"+FlatBooking.getTenantId());
			System.out.println("Booking Number :"+FlatBooking.getBookingNo());
			System.out.println("Booking from Date :"+FlatBooking.getBookingFromDate());
			System.out.println("Booking to Date :"+FlatBooking.getBookingToDate());
		});
		return allFlatBooking;
	}
	
	public static boolean validateFlatBooking(FlatBooking flatBooking)
			throws FlatBookingNotFoundException, TenantNotFoundException {
		logger.info("validateFlatBooking() is initiated");
		boolean flag = false;
		if (flatBooking == null) {
			logger.error("Flat Booking details cannot be blank");
			throw new FlatBookingNotFoundException("Flat Booking details cannot be blank");
		} else {
			validateBookingFromDate(flatBooking);
			validateBookingToDate(flatBooking);
			flag = true;
			logger.info("validationSuccessful");
		}
		logger.info("validateFlatBooking() has executed");
		return flag;

	}

	public static boolean validateBookingFromDate(FlatBooking flatbooking) throws FlatBookingNotFoundException {
		logger.info("validateFlatBookingFromDate() is initiated");
		boolean flag = false;
		if (flatbooking.getBookingFromDate() == null) {
			logger.error("Booking_From_Date cannot be empty");
			throw new FlatBookingNotFoundException("Booking_From_Date cannot be empty");
		} else if (!flatbooking.getBookingFromDate().isAfter(LocalDate.now())) {
			logger.error("Booking_From_Date cannot be after Current_System_Date");
			throw new FlatBookingNotFoundException("Booking_From_Date cannot be after Current_System_Date");
		} else {
			flag = true;
			logger.info(validationSuccessful);
		}
		logger.info("validateFlatBookingFromDate() has executed");
		return flag;
	}

	public static boolean validateBookingToDate(FlatBooking flatbooking) throws FlatBookingNotFoundException {
		logger.info("validateFlatBookingtoDate() is initiated");
		boolean flag = false;
		if (flatbooking.getBookingToDate() == null) {
			logger.error("Booking_To_Date cannot be empty");
			throw new FlatBookingNotFoundException("Booking_To_Date cannot be empty");
		} else if (flatbooking.getBookingToDate().isBefore(flatbooking.getBookingFromDate())) {
			logger.error("Booking_To_Date cannot be before Booking_From_Date");
			throw new FlatBookingNotFoundException("Booking_To_Date cannot be before Booking_From_Date");
		} else {
			flag = true;
			logger.info(validationSuccessful);
		}
		logger.info("validateFlatBookingToDate() has executed");
		return flag;
	}

	
}
