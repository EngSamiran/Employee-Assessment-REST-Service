package com.eas.dto;

public class AuthenticationDTO {
	private String jwtToken;

	public AuthenticationDTO() {
		super();
	}
	public AuthenticationDTO(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	
}
