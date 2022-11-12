package com.example.hr_request_tracker.hr_request_tracker.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.model.TicketType;

public interface ITicketTypeService {
	public Optional<TicketType> findById(final int id);
	public List<TicketType> findAll();
	public TicketType save(final TicketType ticketType);
	public TicketType update(final TicketType ticketType);
	public TicketType deleteById(final int id);
}
