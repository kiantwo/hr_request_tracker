package com.example.hr_request_tracker.hr_request_tracker.ticket.model;

import java.time.LocalDate;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

public interface IAgingTicket {
	Integer getTicketID();
	TicketType getTracker();
	Status getStatus();
	User getAssignee();
	String getSubject();
	LocalDate getCreatedAt();
}
