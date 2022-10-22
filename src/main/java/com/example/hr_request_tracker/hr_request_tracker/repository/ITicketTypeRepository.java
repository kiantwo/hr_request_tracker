package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import com.example.hr_request_tracker.hr_request_tracker.model.TicketType;

public interface ITicketTypeRepository {
	public TicketType findById(final int id);
	public List<TicketType> findAll();
	public int save(final TicketType ticketType);
	public int updateByID(final TicketType ticketType);
	public int deleteByID(final int id);	
}
