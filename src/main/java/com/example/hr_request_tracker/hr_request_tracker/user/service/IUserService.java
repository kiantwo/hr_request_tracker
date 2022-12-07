package com.example.hr_request_tracker.hr_request_tracker.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

public interface IUserService {
	public Optional<User> findById(Integer id);
	public User login(String username, String password);
	public List<User> findAll();
	public Page<Ticket> findAllByUserID(Integer id, Pageable pageable);
	public List<Ticket> findUserAgingTickets(User user);
	public List<Ticket> findAllAgingTickets();
	public User save(User user);
	public User update(User user);
	public Integer deleteById(Integer id) throws Exception;
}
