package com.example.hr_request_tracker.hr_request_tracker.role.model;

public class Role {
	private int roleID;
	private String role;
	private String roleAbbv;
	
	public Role() {}
	
	public Role(final int id, final String role, final String roleAbbv) {
		this.roleID = id;
		this.role = role;
		this.roleAbbv = roleAbbv;
	}
	
	public int getRoleID() {
		return this.roleID;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String roleAbbv() {
		return this.roleAbbv;
	}
	
	public void setRoleID(final int id) {
		this.roleID = id;
	}
	
	public void setRole(final String role) {
		this.role = role;
	}
	
	public void setRoleAbbv(final String roleAbbv) {
		this.roleAbbv = roleAbbv;
	}
}
