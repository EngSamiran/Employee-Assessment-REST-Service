package com.eas.service_impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.eas.custom_exception.AccountValidationException;
import com.eas.custom_exception.UserRoleNotFound;
import com.eas.dto.AuthenticationDTO;
import com.eas.entity.AuthRequestParameter;
import com.eas.service.AuthenticationService;
import com.eas.utils.JwtUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public AuthenticationDTO getLoginResponse(AuthRequestParameter authRequestParameter) {
		try {
			Authentication authenticate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
					authRequestParameter.getUserName(),
					authRequestParameter.getPassword())
							);
			return new AuthenticationDTO(jwtUtil.generateToken(authRequestParameter.getUserName()));
		} catch (InternalAuthenticationServiceException | CredentialsExpiredException e) {
			throw new AccountValidationException("Account validation failed. Please contact support for assistance.");
		} catch (DisabledException e) {
			throw new AccountValidationException("Account is disabled. Please contact support for assistance.");
		} catch (Exception e) {
			throw new UserRoleNotFound("User not found. Please check your input and try again.");
		}
	}
}
