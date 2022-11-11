package com.example.hr_request_tracker.hr_request_tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_module")
public class Ticket {
	@Id
	private int ticketID;
	@Column(name="asignee")
	private String assignee;
	private String status;
	private String subject;
	private String description;
	private String tracker;
		
	public int getTicketID() {
		return this.ticketID;
	}
	
	public String getAssignee() {
		return this.assignee;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getTracker() {
		return this.tracker;
	}
	
	public void setTicketID(int id) {
		this.ticketID = id;
	}
	
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setTracker(String tracker) {
		this.tracker = tracker;
	}
}
