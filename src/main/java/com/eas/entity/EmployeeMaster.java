package com.eas.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "EMPLOYEE_MASTER")
@Entity(name = "EMPLOYEE_MASTER")
public class EmployeeMaster {
	
	@Id
	@Column(name = "USERID", nullable = false, length = 100)
	private String userId;
	
	@Column(name = "EMPLOYEEID", nullable = true, length = 100, unique = true)
	private String employeeId;
	
	@Column(name = "USERNAME", nullable = false, length = 100)
	private String userName;
	
	@Column(name = "PASSWORD", nullable = true, length = 100)
	private String password;
	
	@Column(name = "VALIDFROMDATE", nullable = false)
	private LocalDateTime validFromDate;
	
	@Column(name = "VALIDTODATE", nullable = true)
	private LocalDateTime validToDate;
	
	@Column(name = "ACTIVEFLAG", nullable = false, length = 1)
	private char activeFlag;
	
	@Column(name = "CREATEDT", nullable = false)
	private LocalDateTime createDt;
	
	@Column(name = "CREATEBY", nullable = false, length = 20)
	private String createBy;
	
	@Column(name = "MODDT", nullable = true)
	private LocalDateTime modDt;
	
	@Column(name = "MODBY", nullable = true, length = 100)
	private String modBy;

	@Column(name = "EMAILID", nullable = true, length = 100)
	private String emailId;
	
	@Column(name = "LASTPASSWORDUPDATEDATE", nullable = true)
	private LocalDateTime lastPasswordUpdateDate;
	
	@Column(name = "mobileNumber", nullable = false, length = 10)
	private String mobileNumber;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "userMaster", fetch = FetchType.EAGER)
	private List<EmployeeRoleMaster> sysUserRole;
	
	public EmployeeMaster() {
		super();
	}
	
	public EmployeeMaster(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(LocalDateTime validFromDate) {
		this.validFromDate = validFromDate;
	}

	public LocalDateTime getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(LocalDateTime validToDate) {
		this.validToDate = validToDate;
	}

	public char getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}

	public LocalDateTime getCreateDt() {
		return createDt;
	}

	public void setCreateDt(LocalDateTime createDt) {
		this.createDt = createDt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public LocalDateTime getModDt() {
		return modDt;
	}

	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDateTime getLastPasswordUpdateDate() {
		return lastPasswordUpdateDate;
	}

	public void setLastPasswordUpdateDate(LocalDateTime lastPasswordUpdateDate) {
		this.lastPasswordUpdateDate = lastPasswordUpdateDate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<EmployeeRoleMaster> getSysUserRole() {
		return sysUserRole;
	}

	public void setSysUserRole(List<EmployeeRoleMaster> sysUserRole) {
		this.sysUserRole = sysUserRole;
	}
	
}
