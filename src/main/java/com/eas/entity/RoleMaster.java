package com.eas.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "ROLE_MASTER")
@Entity(name = "ROLE_MASTER")
public class RoleMaster {
	@Id
	@Column(name = "roleid", nullable = false, length = 50)
	private Long roleId;
	@Column(name = "rolename", nullable = false, length = 100)
	private String roleName;
	@Column(name = "comments", nullable = true, length = 500)
	private String comments;
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

	@JsonIgnore
	@OneToMany(mappedBy = "sysRole", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EmployeeRoleMaster> sysUserRole;

	public RoleMaster() {
		super();
	}

	public RoleMaster(Long roleId, String roleName, String comments, char activeFlag, LocalDateTime createDt,
			String createBy, LocalDateTime modDt, String modBy, Set<EmployeeRoleMaster> sysUserRole) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.comments = comments;
		this.activeFlag = activeFlag;
		this.createDt = createDt;
		this.createBy = createBy;
		this.modDt = modDt;
		this.modBy = modBy;
		this.sysUserRole = sysUserRole;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Set<EmployeeRoleMaster> getSysUserRole() {
		return sysUserRole;
	}

	public void setSysUserRole(Set<EmployeeRoleMaster> sysUserRole) {
		this.sysUserRole = sysUserRole;
	}
	
	

	
}
