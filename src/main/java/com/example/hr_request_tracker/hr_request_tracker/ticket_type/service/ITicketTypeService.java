package com.example.hr_request_tracker.hr_request_tracker.ticket_type.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;

public interface ITicketTypeService {
	public Optional<TicketType> findById(Integer id);
	public List<TicketType> findAll();
	public TicketType save(TicketType ticketType);
	public TicketType update(TicketType ticketType);
	public void delete(Integer id);
}
