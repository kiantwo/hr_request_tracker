package com.example.hr_request_tracker.hr_request_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.model.User;
import com.example.hr_request_tracker.hr_request_tracker.repository.ITicketTypeRepository;
import com.example.hr_request_tracker.hr_request_tracker.repository.IUserRepository;
import com.google.gson.Gson;

@Service
public class UserService implements IUserService{
	
	private IUserRepository repository;
	private Gson gson;
	
	@Autowired
	public UserService (final IUserRepository repository) {
		this.repository = repository;
		this.gson = new Gson();			
	}
	public String findById(int id) {
		return gson.toJson(repository.findById(id));
	}

	public String findAll() {
		return gson.toJson(repository.findAll());
	}
	public int save(User user) {
		return gson.toJson(repository.save(user));
	}

	public int update(User user) {
		return gson.toJson(repository.updateByID(user));
	}


	public int deleteById(int id) {
		return repository.deleteByID(id);
	}
	

}
