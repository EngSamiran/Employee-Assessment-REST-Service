package com.eas.custom_exception;

public class UserRoleNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserRoleNotFound(String message) {
		super(message);
	}

	
}
