package com.example.hr_request_tracker.hr_request_tracker.ticket_type.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.repository.ITicketTypeRepository;

@Service
public class TicketTypeService implements ITicketTypeService{
	@Autowired
	private ITicketTypeRepository repository;

	public Optional<TicketType> findById(Integer id) {
		return repository.findById(id);
	}

	public List<TicketType> findAll() {
		return repository.findAll();
	}

	public TicketType save(TicketType type) {
		return repository.save(type);
	}

	public TicketType update(TicketType type) {
		return repository.save(type);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
