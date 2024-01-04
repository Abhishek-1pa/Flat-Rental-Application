package com.cg.flatrental.app.exception;

public class FlatNotFoundException   extends RuntimeException{

private static final long serialVersionUID = 1L;

	
	public FlatNotFoundException(String message)
	{
		super(message);
	}
}
