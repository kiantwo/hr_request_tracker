package com.example.hr_request_tracker.hr_request_tracker.ticket.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

public interface ITicketService {
	public Optional<Ticket> findById(int id);
	public List<Ticket> findAll();
	public List<Ticket> findByAging();
	public List<Ticket> findByAgingCategory(TicketType category);
	public Integer findByCountCategory(TicketType category);
	public Integer findByCountUser(User user);
	public Ticket save(Ticket ticket);
	public Ticket update(Ticket ticket);
	public Integer updateAssignee(Integer id, User assignee);
	public Integer updateStatus(Integer id, Status status);
	public Integer delete(Integer id) throws Exception;
}
