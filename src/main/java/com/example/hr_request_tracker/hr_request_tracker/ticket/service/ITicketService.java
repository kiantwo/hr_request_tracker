package com.example.hr_request_tracker.hr_request_tracker.ticket.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;

public interface ITicketService {
	public Optional<Ticket> findById(int id);
	public List<Ticket> findAll();
	public Ticket save(Ticket ticket);
	public Ticket update(Ticket ticket);
//	public int updateAssignee(int id, String assignee);
//	public int updateStatus(int id, String status);
	public void deleteById(Integer id);
}
