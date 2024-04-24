package com.eas.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeDTO {
	private long id;
	
	@NotNull(message = "Name must not be null")
    @Size(min = 5, max = 100, message = "Name length must be greater than 4 and less than or equal to 100 characters")
	private String name;
	
	@NotNull(message = "Email must not be null")
    @Size(min = 10, max = 100, message = "Email length must be greater than 9 and less than or equal to 100 characters")
	private String email;
	
	@NotNull(message = "Department must not be null")
    @Size(min = 2, max = 50, message = "Department name length must be greater than 2 and less than or equal to 50 characters")
	private String department;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(long id, String name, String email, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
