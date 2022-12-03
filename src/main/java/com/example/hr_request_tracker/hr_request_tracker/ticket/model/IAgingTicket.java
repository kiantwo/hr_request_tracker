package com.example.hr_request_tracker.hr_request_tracker.ticket.model;

import java.time.LocalDate;

import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;

public interface IAgingTicket {
	Integer getTicketID();
	TicketType getTracker();
	LocalDate getCreatedAt();
}
