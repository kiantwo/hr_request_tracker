package com.example.hr_request_tracker.hr_request_tracker.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.repository.ITicketRepository;

@Service
public class TicketService implements ITicketService{
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
	
	public void deleteById(Integer id)
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
		
//	public int updateStatus (int id, String status) {
//		return repository.updateStatus(id, status);
//	}
//	
//	public int updateAssignee (int id, String assignee) {
//		return repository.updateAssignee(id, assignee);
//	}
	
	
}
