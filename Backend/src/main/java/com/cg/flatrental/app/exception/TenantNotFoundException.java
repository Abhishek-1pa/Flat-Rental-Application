package com.cg.flatrental.app.exception;

public class TenantNotFoundException extends RuntimeException {
	public TenantNotFoundException(String message) {
		super(message);
	}
}
