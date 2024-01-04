package com.cg.flatrental.app.hanlder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flatrental.app.exception.TenantNotFoundException;


@RestControllerAdvice
public class TenantNotFoundExceptionHandler {
	@Autowired
	private JSONObjects obj;
	@ExceptionHandler(TenantNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(TenantNotFoundException tnfe)
	{
		obj.setError(tnfe.getMessage());
		ResponseEntity<Object> rentity=new ResponseEntity<Object>(obj,HttpStatus.NOT_FOUND);
		return rentity;
	}

}