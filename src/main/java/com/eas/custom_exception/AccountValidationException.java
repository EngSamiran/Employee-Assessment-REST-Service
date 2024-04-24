package com.eas.custom_exception;

public class AccountValidationException extends RuntimeException {

	private static final long serialVersionUID = -4594697562996544217L;

	public AccountValidationException(String message) {
		super(message);
	}
}
