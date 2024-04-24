package com.eas.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "EMPLOYEE_ROLE_MASTER")
@Entity(name = "EMPLOYEE_ROLE_MASTER")
public class EmployeeRoleMaster {
	@Id
	@Column(name = "sysuserroleid", nullable = false, length = 50)
	private Long sysUserRoleId;
	
	@Column(name = "activeflag", nullable = false, length = 1)
	private char activeFlag;
	@Column(name = "createdt", nullable = false)
	private LocalDateTime createDt;
	@Column(name = "createby", nullable = false, length = 20)
	private String createBy;
	@Column(name = "moddt", nullable = true)
	private LocalDateTime modDt;
	@Column(name = "modby", nullable = true, length = 100)
	private String modBy;

	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID")
	private EmployeeMaster userMaster;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private RoleMaster sysRole;

	public EmployeeRoleMaster() {
		super();
	}

	public Long getSysUserRoleId() {
		return sysUserRoleId;
	}

	public void setSysUserRoleId(Long sysUserRoleId) {
		this.sysUserRoleId = sysUserRoleId;
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

	public EmployeeMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(EmployeeMaster userMaster) {
		this.userMaster = userMaster;
	}

	public RoleMaster getSysRole() {
		return sysRole;
	}

	public void setSysRole(RoleMaster sysRole) {
		this.sysRole = sysRole;
	}
	
}
