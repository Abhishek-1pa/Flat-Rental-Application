package com.cg.flatrental.app.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
