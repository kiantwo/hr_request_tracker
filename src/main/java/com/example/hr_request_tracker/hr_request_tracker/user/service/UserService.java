package com.example.hr_request_tracker.hr_request_tracker.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.user.model.User;
import com.example.hr_request_tracker.hr_request_tracker.user.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository repository;
	
	public Optional<User> findById(Integer id) {
		return repository.findById(id);
	}
	
	public Optional<User> findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public User login(String username, String password) {
		return repository.login(username, password);
	}

	public List<User> findAll() {
		return repository.findAllByUsernameNotAdmin();
	}
	
	public User save(User user) {
		return repository.save(user);
	}

	public User update(User user) {
		return repository.save(user);
	}
	
	public Integer updatePassword(Integer id, String password) {
		return repository.updatePassword(id, password);
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
