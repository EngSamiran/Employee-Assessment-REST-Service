package com.eas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eas.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
}
