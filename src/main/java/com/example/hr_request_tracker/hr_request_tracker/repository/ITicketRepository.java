package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;


public interface ITicketRepository {
	public Ticket findById(final int id);
	public List<Ticket> findAll();
	public int save(final Ticket user);
	public int updateByID(final Ticket user);
	public int updateAssignee(final int id, final String assignee);
	public int updateStatus(final int id, final String status);
	public int deleteByID(final int id);
}
