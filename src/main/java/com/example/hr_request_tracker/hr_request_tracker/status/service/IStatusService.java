package com.example.hr_request_tracker.hr_request_tracker.status.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;

public interface IStatusService {
	public Optional<Status> findByID(Integer id);
	public List<Status> findAll();
	public Status save(Status status);
	public Status update(Status status);
	public Integer deleteById(int id) throws Exception;
}
