package com.example.hr_request_tracker.hr_request_tracker.status.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.status.repository.IStatusRepository;

@Service
public class StatusService implements IStatusService {
	@Autowired
	private IStatusRepository repository;
	
	public Optional<Status> findByID(Integer id) {
		return repository.findById(id);
	}
	
	public List<Status> findAll() {
		return repository.findAll();
	}
	
	public Status save(Status status) {
		return repository.save(status);
	}
	
	public Status update(Status status) {
		return repository.save(status);
	}
	
	public Integer deleteById(int id) throws Exception {
		try {
			repository.deleteById(id);
			return 1;
		} catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
}
