package com.example.hr_request_tracker.hr_request_tracker.ticket.model;

import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;

public interface ITicketCount {
	TicketType getTracker();
	Integer getTrackerCount();
}
