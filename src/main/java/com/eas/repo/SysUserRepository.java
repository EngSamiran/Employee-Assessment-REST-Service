package com.eas.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eas.entity.EmployeeMaster;


@Repository
public interface SysUserRepository extends JpaRepository<EmployeeMaster, String>{
	Optional<EmployeeMaster> findByUserId(String userid);
	Optional<EmployeeMaster> findByEmployeeId(String userId);
}
