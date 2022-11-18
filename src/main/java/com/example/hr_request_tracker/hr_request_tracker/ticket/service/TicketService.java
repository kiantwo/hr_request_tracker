package com.example.hr_request_tracker.hr_request_tracker.ticket.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.repository.ITicketRepository;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Service
public class TicketService implements ITicketService {
	@Autowired
	private ITicketRepository repository;
	
	public Optional<Ticket> findById(int id)
	{
		return repository.findById(id);
	}
	
	public List<Ticket> findAll()
	{
		return repository.findAll();
	}
	
	public void delete(Integer id)
	{
		repository.deleteById(id);
	}
	
	public Ticket save(Ticket ticket)
	{
		return repository.save(ticket);
	}
	
	public Ticket update(Ticket ticket) 
	{
		return repository.save(ticket);
	}
	
	@Transactional
	public Integer updateStatus(Integer id, Status status) {
		return repository.updateStatus(id, status);
	}
	
	@Transactional
	public Integer updateAssignee(Integer id, User assignee) {
		return repository.updateAssignee(id, assignee);
	}
	
	
}
