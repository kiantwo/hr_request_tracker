package com.example.hr_request_tracker.hr_request_tracker.model;

public class Ticket {
	private int ticketID;
	private String assignee;
	private String status;
	private String subject;
	private String description;
	private String tracker;
	
	public Ticket() {}
	
	public Ticket(final int id, final String assignee, final String status, 
			final String subject, final String description, final String tracker) {
		this.ticketID = id;
		this.assignee = assignee;
		this.status = status;
		this.subject = subject;
		this.description = description;
		this.tracker = tracker;
	}
	
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
	
	public void setTicketID(final int id) {
		this.ticketID = id;
	}
	
	public void setAssignee(final String assignee) {
		this.assignee = assignee;
	}
	
	public void setStatus(final String status) {
		this.status = status;
	}
	
	public void setSubject(final String subject) {
		this.subject = subject;
	}
	
	public void setDescription(final String description) {
		this.description = description;
	}
	
	public void setTracker(final String tracker) {
		this.tracker = tracker;
	}
}
