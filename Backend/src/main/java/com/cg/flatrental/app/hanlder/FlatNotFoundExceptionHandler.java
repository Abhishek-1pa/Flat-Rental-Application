package com.cg.flatrental.app.hanlder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flatrental.app.exception.FlatNotFoundException;



@RestControllerAdvice
public class FlatNotFoundExceptionHandler {
	@Autowired
	private JSONObjects obj;
	@ExceptionHandler(FlatNotFoundException.class)
	public ResponseEntity<Object>handleExceptionNotFound(FlatNotFoundException cnfe) {
		obj.setError(cnfe.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(obj, HttpStatus.NOT_FOUND);
		return entity;
	}
}