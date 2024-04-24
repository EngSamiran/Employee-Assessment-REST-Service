package com.eas.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthRequestParameter {
	@NotNull(message = "User name must not be null")
    @Size(min = 3, max = 20, message = "User name length must be greater than 2 and less than or equal to 20 characters")
	private String userName;
	
	@NotNull(message = "password must not be null")
    @Size(min = 3, max = 8, message = "password length must be greater than 2 and less than or equal to 8 characters")
	private String password;

	public AuthRequestParameter() {
		super();

	}

	public AuthRequestParameter(
			@NotNull(message = "User name must not be null") @Size(min = 3, max = 20, message = "User name length must be greater than 2 and less than or equal to 20 characters") String userName,
			@NotNull(message = "password must not be null") @Size(min = 3, max = 8, message = "password length must be greater than 2 and less than or equal to 8 characters") String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
