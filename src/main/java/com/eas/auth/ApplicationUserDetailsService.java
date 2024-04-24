package com.eas.auth;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eas.custom_exception.UserRoleNotFound;
import com.eas.entity.EmployeeMaster;
import com.eas.entity.EmployeeRoleMaster;
import com.eas.entity.RoleMaster;
import com.eas.service.SysUserService;


@Service
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
	private SysUserService sysUsersServices;

	private Collection<? extends GrantedAuthority> grantedAuthority = null;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		EmployeeMaster userMaster = sysUsersServices.findByUserId(userId);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		if (userMaster != null) {
			List<EmployeeRoleMaster> sysUserRole = userMaster.getSysUserRole();
			if (sysUserRole != null && sysUserRole.size()>0) {
				for (EmployeeRoleMaster master : sysUserRole) {
					RoleMaster sysRole2 = master.getSysRole();
					String roleName = sysRole2.getRoleName();
					authorities.add(new SimpleGrantedAuthority(roleName));
				}
			} else {
				throw new UserRoleNotFound("Your application access role has not been created. Please contact the Admin team for assistance. Thank you.");

			}
		}
		//Account validation
		char activeFlag = userMaster.getActiveFlag();
		boolean isAccountNonActive = false;
		if(activeFlag=='Y') {
			isAccountNonActive = true;
		}
		
		LocalDateTime validFromDate = userMaster.getValidFromDate();
		LocalDateTime validToDate = userMaster.getValidToDate();
		boolean isCredentialNonExpired = false;
		LocalDateTime systemCurrentLocalDateTime = getSystemCurrentLocalDateTime();
		if(systemCurrentLocalDateTime.isAfter(validFromDate) 
				&& systemCurrentLocalDateTime.isBefore(validToDate)) {
			isCredentialNonExpired = true;
		}
		
		return new ApplicationUser(authorities,
				userId, 
				userMaster.getPassword(),
				true, true, 
				isCredentialNonExpired, isAccountNonActive);

	}
	
	private LocalDateTime getSystemCurrentLocalDateTime() {
		return LocalDateTime.now();
	}
}
