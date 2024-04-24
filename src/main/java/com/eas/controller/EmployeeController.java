package com.eas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eas.custom_exception.BadRequest;
import com.eas.dto.EmployeeDTO;
import com.eas.service.EmployeeService;
import com.eas.utils.AllRequestPath;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RateLimiter(name = "employeeAccessRateLimiter", fallbackMethod = "employeeAccessFallback")
	@PostMapping(path = AllRequestPath.ADD_EMPLOYEE, produces = "application/json")
	public ResponseEntity<?> addNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		if (employeeDTO != null) {
			return employeeService.addNewEmployee(employeeDTO);
		} else {
			throw new BadRequest("Employee information cannot be null. Please provide valid employee details.");
		}
	}
	@RateLimiter(name = "employeeRateLimiter", fallbackMethod = "employeeAccessFallback")
	@GetMapping(path = AllRequestPath.GET_EMPLOYEE_BY_ID, produces = "application/json")
	public ResponseEntity<?> getEmployeeById(@PathVariable(name = "empId") long empId) {
		if (empId > 0) {
			return employeeService.getEmployeeById(empId);
		} else {
			throw new BadRequest("Employee ID must be greater than 0. Please provide a valid employee ID.");
		}
	}

	@GetMapping(path = AllRequestPath.GET_ALL_EMPLOYEE, produces = "application/json")
	public ResponseEntity<?> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PutMapping(path = AllRequestPath.UPDATE_EMPLOYEE_BY_ID, produces = "application/json")
	public ResponseEntity<?> updateEmployeesById(@Valid @PathVariable(name = "empId") Long empId,
			@RequestBody EmployeeDTO employeeDTO) {
		if (empId != null || employeeDTO != null) {
			return employeeService.UpdateEmployeeById(empId, employeeDTO);
		} else {
			throw new BadRequest("Employee ID and employee information cannot be null. Please provide valid employee details.");
		}
	}

	@DeleteMapping(path = AllRequestPath.DELETE_EMPLOYEE_BY_ID, produces = "application/json")
	public ResponseEntity<?> deleteEmployeesById(@PathVariable(name = "empId") long empId) {
		if (empId > 0) {
			return employeeService.deleteEmployeeById(empId);
		} else {
			throw new BadRequest("Please enter a correct employee ID.");
		}
	}
	
	public ResponseEntity<EmployeeDTO> employeeAccessFallback(long id, Exception exception){
		EmployeeDTO employeeDTO = new EmployeeDTO(00000, "fallback name", "fallback email", "fallback department");
		return ResponseEntity.ok(employeeDTO);
	}

}
