package com.eas.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eas.custom_exception.ResourceNotFoundException;
import com.eas.entity.EmployeeMaster;
import com.eas.repo.SysUserRepository;
import com.eas.service.SysUserService;

@Service
public class SysUserServiceImplementation implements SysUserService {

	@Autowired
	private SysUserRepository sysUserRepo;

	@Override
	public EmployeeMaster findByUserId(String userId) {
			EmployeeMaster master = sysUserRepo
					.findByUserId(userId).orElseThrow(()-> new ResourceNotFoundException("Bad Request"));
			return master;
	}

}
