package com.example.hr_request_tracker.hr_request_tracker.service;
import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.repository.ITicketRepository;
import com.google.gson.Gson;




public class TicketService implements ITicketService{
	private ITicketRepository repository;
	private Gson gson;
	
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
	
	public int save(final BufferedReader body)
	{
		//from just a simple requestBody, we transform it to a class using fromJson
		final Ticket ticket= gson.fromJson(body, Ticket.class);
		
		return repository.save(ticket);
	}
	
	public int update(final Ticket ticket)
	{
		return repository.updateByID(ticket);
	}
	
	public int updateStatus (final Ticket ticket) {
		return repository.updateByID(ticket);
	}
	
	public int updateAssignee (final Ticket ticket) {
		return repository.updateByID(ticket);
	}
	
	
}
