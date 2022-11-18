package com.example.hr_request_tracker.hr_request_tracker.status.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;

@Entity
@Table(name="status")
public class Status {
	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusID;
	@Column(name="status_name")
	private String statusName;
	private String description;
	
	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
	private Set<Ticket> tickets;
	
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
