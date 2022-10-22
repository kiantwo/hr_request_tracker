package com.example.hr_request_tracker.hr_request_tracker.service;

import com.example.hr_request_tracker.hr_request_tracker.model.TicketType;

public interface ITicketTypeService {
	public String findById(final int id);
	public String findAll();
	public int save(final TicketType ticketType);
	public int update(final TicketType ticketType);
	public int deleteById(final int id);
}