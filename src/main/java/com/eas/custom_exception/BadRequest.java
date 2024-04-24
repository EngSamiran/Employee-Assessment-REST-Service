package com.eas.custom_exception;

public class BadRequest extends RuntimeException{

	private static final long serialVersionUID = 7330694348233314118L;

	public BadRequest(String message) {
		super(message);
	}

	public BadRequest(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
