package com.eas.service;

import com.eas.entity.EmployeeMaster;

public interface SysUserService {
	EmployeeMaster findByUserId(String userId);
}
