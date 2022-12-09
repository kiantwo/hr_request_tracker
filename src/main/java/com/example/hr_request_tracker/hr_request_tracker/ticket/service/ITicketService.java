package com.example.hr_request_tracker.hr_request_tracker.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IAgingTicket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.ITicketCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IUserCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

public interface ITicketService {
	public Optional<Ticket> findById(int id);
	public List<Ticket> findAll();
	public Page<Ticket> findAllPageable(String search, String filter, Pageable pageable);
	public Page<Ticket> findAllByUserID(String search, Integer id, Pageable pageable);
	public Page<Ticket> findUserAgingTickets(User user, Pageable pageable);
	public Page<Ticket> findAllAgingTickets(Pageable pageable);
	public List<Ticket> findByAging();
	public List<IAgingTicket> findByAgingCategory();
	public List<ITicketCount> findByCountCategory();
	public List<IUserCount> findByCountUser();
	public Ticket save(Ticket ticket);
	public Ticket update(Ticket ticket);
	public Integer updateAssignee(Integer id, User assignee);
	public Integer updateStatus(Integer id, Status status);
	public Integer delete(Integer id) throws Exception;
}
