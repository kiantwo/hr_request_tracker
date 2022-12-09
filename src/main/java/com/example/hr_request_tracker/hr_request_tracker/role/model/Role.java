package com.example.hr_request_tracker.hr_request_tracker.role.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleID;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_abbv")
	private String roleAbbv;
	
	@OneToMany(mappedBy="role", cascade = CascadeType.ALL)
	private Set<User> users;
		
	public int getRoleID() {
		return this.roleID;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
	
	public String getRoleAbbv() {
		return this.roleAbbv;
	}
	
	public void setRoleID(final int id) {
		this.roleID = id;
	}
	
	public void setRoleName(final String roleName) {
		this.roleName = roleName;
	}
	
	public void setRoleAbbv(final String roleAbbv) {
		this.roleAbbv = roleAbbv;
	}
}
