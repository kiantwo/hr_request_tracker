package com.example.hr_request_tracker.hr_request_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.repository.ITicketTypeRepository;
import com.google.gson.Gson;

@Service
public class TicketTypeService implements ITicketTypeService{
	private ITicketTypeRepository repository;
	private Gson gson;
	
	@Autowired
	public TicketTypeService (final ITicketTypeRepository repository) {
		this.repository = repository;
		this.gson = new Gson();			
	}
	public String findById(int id) {
		return gson.toJson(repository.findById(id));
	}

	public String findAll() {
		return gson.toJson(repository.findAll());
	}

	public int save(TicketType type) {
		return repository.save(type);
	}

	public int update(TicketType type) {
		return repository.updateByID(type);
	}

	public int deleteById(int id) {
		return repository.deleteByID(id);
	}
	
}
