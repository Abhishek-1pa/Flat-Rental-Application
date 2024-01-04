package com.cg.flatrental.app.exception;

public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
