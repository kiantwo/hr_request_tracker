package com.example.hr_request_tracker.hr_request_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.model.User;
import com.example.hr_request_tracker.hr_request_tracker.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository repository;
	
	public Optional<User> findById(Integer id) {
		return repository.findById(id);
	}

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User save(User user) {
		return repository.save(user);
	}

	public User update(User user) {
		return repository.save(user);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	

}
