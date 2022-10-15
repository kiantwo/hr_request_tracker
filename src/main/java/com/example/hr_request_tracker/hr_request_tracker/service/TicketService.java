package com.example.hr_request_tracker.hr_request_tracker.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.repository.ITicketRepository;
import com.google.gson.Gson;

@Service
public class TicketService implements ITicketService{
	private ITicketRepository repository;
	private Gson gson;
	
	@Autowired
	public TicketService (final ITicketRepository repository) {
		this.repository = repository;
		this.gson = new Gson();			
	}
	public String findById(final int id)
	{
		return gson.toJson(repository.findById(id));
	}
	
	public String findAll()
	{
		return gson.toJson(repository.findAll());
	}
	
	public int deleteById(final int id)
	{
		return repository.deleteByID(id);
	}
	
	public int save(final Ticket ticket)
	{
		return repository.save(ticket);
	}
	
	public int update(final Ticket ticket)
	{
		return repository.updateByID(ticket);
	}
	
	
	public int updateStatus (final int id, final String status) {
		return repository.updateStatus(id, status);
	}
	
	public int updateAssignee (final int id, final String assignee) {
		return repository.updateAssignee(id, assignee);
	}
	
	
}
