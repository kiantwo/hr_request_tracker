package com.example.hr_request_tracker.hr_request_tracker.status.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status {
	@Id
	@Column(name="status_id")
	private int statusID;
	@Column(name="status_name")
	private String statusName;
	private String description;
	
	public int getStatusID() {
		return this.statusID;
	}
	
	public String getStatusName() {
		return this.statusName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
