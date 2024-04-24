package com.eas.service;

import com.eas.dto.AuthenticationDTO;
import com.eas.entity.AuthRequestParameter;

public interface AuthenticationService {
	public AuthenticationDTO getLoginResponse(AuthRequestParameter authRequestParameter);
}
