package com.example.hr_request_tracker.hr_request_tracker.status.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.status.messages.StatusMessages;
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
	public ApiResponse save(Status status) {
		Status savedStatus = service.save(status);
		
		if(savedStatus != null) {
			return ApiResponse.CreateSuccess(savedStatus, StatusMessages.STATUS_SUCCESSFULLY_SAVED);
		}
		
		return ApiResponse.CreateError(StatusMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@PostMapping("/status/update")
	public ApiResponse update(Status status) {
		Status updatedStatus = service.update(status);
		
		if(updatedStatus != null) {
			return ApiResponse.CreateSuccess(updatedStatus, StatusMessages.STATUS_SUCCESFULLY_UPDATED);
		}
		
		return ApiResponse.CreateError(StatusMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@DeleteMapping("/status/delete/{id}")
	public ApiResponse delete(@PathVariable int id) throws Exception {
		int result = service.deleteById(id);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, StatusMessages.STATUS_SUCCESSFULLY_DELETED);
		}
		
		return ApiResponse.CreateError(StatusMessages.GENERIC_UNSUCCESSFUL_DELETE);
	}
}
