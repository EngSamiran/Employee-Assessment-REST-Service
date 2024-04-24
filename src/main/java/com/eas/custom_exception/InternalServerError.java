package com.eas.custom_exception;

public class InternalServerError extends RuntimeException{

	private static final long serialVersionUID = -7339355590709059843L;

	public InternalServerError(String message, Throwable cause) {
		super(message, cause);
	}

	public InternalServerError(String message) {
		super(message);
	}
	

}
