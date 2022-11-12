package com.example.hr_request_tracker.hr_request_tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@Column(name="ticket_id")
	private int ticketID;
	@Column(name="assignee_id")
	private Integer assignee;
	@Column(name="tracker_id")
	private Integer tracker;
	private String status;
	private String subject;
	private String description;

	public int getTicketID() {
		return this.ticketID;
	}
	
	public Integer getAssignee() {
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
	
	public Integer getTracker() {
		return this.tracker;
	}
	
	public void setTicketID(int id) {
		this.ticketID = id;
	}
	
	public void setAssignee(Integer assignee) {
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
	
	public void setTracker(Integer tracker) {
		this.tracker = tracker;
	}
}
