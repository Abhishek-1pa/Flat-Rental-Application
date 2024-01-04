package com.cg.flatrental.app.hanlder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flatrental.app.exception.FlatBookingNotFoundException;


@RestControllerAdvice
public class FlatBookingNotFoundExceptionHandler {
	@Autowired
	private JSONObjects obj;
	@ExceptionHandler(FlatBookingNotFoundException.class)
	public ResponseEntity<Object> handleLandlordNotFoundException(FlatBookingNotFoundException exe)
	{
		obj.setError(exe.getMessage());
		ResponseEntity<Object> retvalue=new ResponseEntity<Object>(obj,HttpStatus.NOT_FOUND);
		return retvalue;
	}
}