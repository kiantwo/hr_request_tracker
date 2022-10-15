package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;


public interface ITicketRepository {
	public Ticket findById(final int id);
	public List<Ticket> findAll();
	public int save(final Ticket user);
	public int updateByID(final Ticket user);
	public int deleteByID(final int id);
}
