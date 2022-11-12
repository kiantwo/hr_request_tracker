package com.example.hr_request_tracker.hr_request_tracker.status.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.status.service.IStatusService;

@RestController
public class StatusController {
	@Autowired
	private IStatusService service;
	
	@RequestMapping("/status/{id}")
	public Optional<Status> getById(@PathVariable int id) {
		return service.findByID(id);
	}
	
	@RequestMapping("/status")
	public List<Status> getAll() {
		return service.findAll();
	}
	
	@PostMapping("/status/create")
	public Status save(Status status) {
		return service.save(status);
	}
	
	@PostMapping("/status/update")
	public Status update(Status status) {
		return service.update(status);
	}
	
	@PostMapping("/status/delete")
	public void delete(Status status) {
		service.delete(status);
	}
}
