package com.eas.service_impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eas.custom_exception.BadRequest;
import com.eas.custom_exception.InternalServerError;
import com.eas.custom_exception.ResourceNotFoundException;
import com.eas.dto.EmployeeDTO;
import com.eas.entity.Employee;
import com.eas.entity.EmployeeMaster;
import com.eas.repo.EmployeeRepo;
import com.eas.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseEntity<?> addNewEmployee(EmployeeDTO employeeDTO) {
		try {
			Employee newEmployee = modelMapper.map(employeeDTO, Employee.class);
			newEmployee.setCreateDT(getSystemLocalDateTime());
			newEmployee.setCREATEBY(getPayloadLogger());
			Employee savedEmployee = employeeRepo.save(newEmployee);

			if (savedEmployee != null) {
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(modelMapper.map(savedEmployee, EmployeeDTO.class));
			} else {
				throw new InternalServerError(
						"Faild to add " + newEmployee.getName() + " information into our system.");
			}
		} catch (InternalServerError ex) {
			throw ex;
		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError("An unexpected error occurred while adding the employee");
		}

	}

	@Override
	public ResponseEntity<?> getEmployeeById(long empId) {
		try {
			Employee employee = employeeRepo
					.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
			return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(employee, EmployeeDTO.class));
		} catch (ResourceNotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError("An unexpected error occurred while getting the employee with id : " + empId);
		}
	}

	@Transactional
	@Override
	public ResponseEntity<?> UpdateEmployeeById(long empId, EmployeeDTO dto) {
		try {
			Employee existingEmployee = employeeRepo.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + empId));

			existingEmployee.setName(dto.getName());
			existingEmployee.setEmail(dto.getEmail());
			existingEmployee.setDepartment(dto.getDepartment());
			Employee updateEmpInfo = employeeRepo.save(existingEmployee);

			if (updateEmpInfo != null) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(modelMapper.map(updateEmpInfo, EmployeeDTO.class));
			} else {
				throw new InternalServerError(
						"Internal server error occurred while update the employee with id : " + empId);
			}
		} catch (ResourceNotFoundException ex) {
			throw ex;
		} 
		catch (InternalServerError ex) {
			throw ex;
		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError(
					"An unexpected error occurred while updating the employee with id : " + empId);
		}
	}

	@Override
	public ResponseEntity<?> deleteEmployeeById(long empId) {
		try {
			employeeRepo.deleteById(empId);
			return ResponseEntity.status(HttpStatus.CREATED).body("Employee with ID " + empId + " has been deleted.");
		} catch (EmptyResultDataAccessException e) {
			throw new BadRequest("Employee ID: " + empId + " not exists!");
		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError("An unexpected error occurred while delete the employee with id : " + empId);
		}
	}

	@Override
	public ResponseEntity<?> getAllEmployees() {
		try {
			List<Employee> employees = employeeRepo.findAll();
			if (employees != null && employees.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(employees.stream().map(this::convertToEmployeeDTO).collect(Collectors.toList()));
			} else {
				throw new ResourceNotFoundException("No Content found");
			}

		} catch (ResourceNotFoundException ex) {
			throw ex;
		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError("An unexpected error occurred while getting all employee information");
		}

	}

	private LocalDateTime getSystemLocalDateTime() {
		return LocalDateTime.now();
	}

	private EmployeeMaster getPayloadLogger() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return new EmployeeMaster(auth.getName());
	}

	private EmployeeDTO convertToEmployeeDTO(Employee employee) {
		return modelMapper.map(employee, EmployeeDTO.class);
	}

}
