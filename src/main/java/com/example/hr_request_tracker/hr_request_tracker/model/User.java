package com.example.hr_request_tracker.hr_request_tracker.model;

public class User {
	private int userID;
	private int roleID;
	private String username;
	private String userFName;
	private String userLName;
	private String password;
	private String email;
	
	public User() {}
	
	public User(final int userID, final int roleID, final String username, 
			final String userFName, final String userLName, final String password, 
			final String email) {
		this.userID = userID;
		this.roleID = roleID;
		this.username = username;
		this.userFName = userFName;
		this.userLName = userLName;
		this.password = password;
		this.email = email;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public int getRoleID() {
		return this.roleID;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getUserFName() {
		return this.userFName;
	}
	
	public String getUserLName() {
		return this.userLName;
	}
	
	public String getUserPassword() {
		return this.password;
	}
	
	public String getUserEmail() {
		return this.email;
	}
	
	public void setUserID(final int id) {
		this.userID = id;
	}
	
	public void setUsername(final String username) {
		this.username = username;
	}
	
	public void setUserFName(final String userFName) {
		this.userFName = userFName;
	}
	
	public void setUserLName(final String userLName) {
		this.userLName = userLName;
	}
	
	public void setUserPassword(final String password) {
		this.password = password;
	}
	
	public void setUserEmail(final String email) {
		this.email = email;
	}
}
