package com.example.hr_request_tracker.hr_request_tracker.ticket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketID;
	
	@ManyToOne
	@JoinColumn(name="assignee_id")
	private User assignee;
	
	@ManyToOne
	@JoinColumn(name="tracker_id")
	private TicketType tracker;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	private String subject;
	private String description;
	private String file;
	
	@Column(name="created_at")
	private LocalDate createdAt;

	public int getTicketID() {
		return this.ticketID;
	}
	
	public User getAssignee() {
		return this.assignee;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getFile() {
		return this.file;
	}
	
	public TicketType getTracker() {
		return this.tracker;
	}
	
	public LocalDate getCreatedAt() {
		return this.createdAt;
	}
	
	public void setTicketID(int id) {
		this.ticketID = id;
	}
	
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setTracker(TicketType tracker) {
		this.tracker = tracker;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = LocalDate.parse(createdAt);
	}
	
	public void setFile(String file) {
		this.file = file;
	}
}
