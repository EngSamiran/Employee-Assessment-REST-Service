package com.eas.custom_exception;

public class HandleValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HandleValidationException(String message) {
		super(message);
	}

	public HandleValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}

