package com.example.hr_request_tracker.hr_request_tracker.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;
import com.example.hr_request_tracker.hr_request_tracker.user.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository repository;
	
	public Optional<User> findById(Integer id) {
		return repository.findById(id);
	}
	
	public User login(String username, String password) {
		return repository.login(username, password);
	}

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public Page<Ticket> findAllByUserID(Integer id, Pageable pageable) {
		return repository.findAllByUserID(id, pageable);
	}
	
	public List<Ticket> findUserAgingTickets(User user) {
		return repository.findUserAgingTickets(user);
	}
	
	public List<Ticket> findAllAgingTickets() {
		return repository.findAllAgingTickets();
	}
	
	public User save(User user) {
		return repository.save(user);
	}

	public User update(User user) {
		return repository.save(user);
	}

	public Integer deleteById(Integer id) throws Exception {
		try {
			repository.deleteById(id);			
			return 1;
		} catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	

}
