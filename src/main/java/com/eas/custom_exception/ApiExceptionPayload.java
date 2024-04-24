package com.eas.custom_exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiExceptionPayload {
	
	private String message;
	private HttpStatus httpStatus;
	private int statusCode;
	private LocalDateTime timeStamp;

	public ApiExceptionPayload(String message, HttpStatus httpStatus, int statusCode, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
