package com.eas.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "EmployeeForTest")
@Entity(name = "EmployeeForTest")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeForTestIdGenerator")
	@SequenceGenerator(name = "employeeForTestIdGenerator", initialValue = 111, allocationSize = 1, sequenceName = "EmployeeForTestId_seq")
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "name", nullable = false, length = 100)
	//@Size(max = 100, min = 5, message = "Name length must be grater than 4 and less than or equal to 100 characters")
	private String name;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "department", nullable = false, length = 50)
	private String department;

	// @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATEBY", nullable = false)
	private EmployeeMaster CREATEBY;// com

	@Column(name = "CREATEDT", nullable = false)
	private LocalDateTime createDT;// com

	// @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODBY", nullable = true)
	private EmployeeMaster MODBY;// com

	@Column(name = "MODDT", nullable = true)
	private LocalDateTime modDT;// com

	public Employee() {
		super();
	}

	public Employee(long id, String name, String email, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}
	
	

	public Employee(long id,
			String name,
			String email, String department, EmployeeMaster cREATEBY, LocalDateTime createDT, EmployeeMaster mODBY,
			LocalDateTime modDT) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		CREATEBY = cREATEBY;
		this.createDT = createDT;
		MODBY = mODBY;
		this.modDT = modDT;
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

	public EmployeeMaster getCREATEBY() {
		return CREATEBY;
	}

	public void setCREATEBY(EmployeeMaster cREATEBY) {
		CREATEBY = cREATEBY;
	}

	public LocalDateTime getCreateDT() {
		return createDT;
	}

	public void setCreateDT(LocalDateTime createDT) {
		this.createDT = createDT;
	}

	public EmployeeMaster getMODBY() {
		return MODBY;
	}

	public void setMODBY(EmployeeMaster mODBY) {
		MODBY = mODBY;
	}

	public LocalDateTime getModDT() {
		return modDT;
	}

	public void setModDT(LocalDateTime modDT) {
		this.modDT = modDT;
	}
	
	

}
