package com.example.hr_request_tracker.hr_request_tracker.service;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;

public interface ITicketTypeService {
	public String findById(final int id);
	public String findAll();
	public int save(final Ticket ticket);
	public int update(final Ticket ticket);
	public int deleteById(final int id);
}
}
