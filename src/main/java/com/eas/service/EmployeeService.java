package com.eas.service;

import org.springframework.http.ResponseEntity;

import com.eas.dto.EmployeeDTO;

public interface EmployeeService {
	public ResponseEntity<?> addNewEmployee(EmployeeDTO employeeDTO);
	public  ResponseEntity<?> getEmployeeById(long empId);
	public ResponseEntity<?> deleteEmployeeById(long empId);
	public ResponseEntity<?> UpdateEmployeeById(long empId, EmployeeDTO dto);
	public ResponseEntity<?> getAllEmployees();
}
