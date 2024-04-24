package com.eas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eas.custom_exception.BadRequest;
import com.eas.entity.AuthRequestParameter;
import com.eas.service.AuthenticationService;
import com.eas.utils.AllRequestPath;

@RestController
@RequestMapping(path = AllRequestPath.AUTHENTICATION)
public class AuthenticationCon {
	
	@Autowired
	private AuthenticationService loginService;

	@PostMapping(produces = "application/json")
	public ResponseEntity<?> generateToken(@Valid @RequestBody AuthRequestParameter authRequest) {
		if(authRequest!= null) {
			return ResponseEntity.status(HttpStatus.OK).body(loginService.getLoginResponse(authRequest));
		}
		else {
			throw new BadRequest("Authentication information cannot be null. Please provide valid authentication details.");

		}
	}

}
