package com.example.hr_request_tracker.hr_request_tracker.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.user.messages.UserMessages;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;
import com.example.hr_request_tracker.hr_request_tracker.user.service.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService service;
	
	@RequestMapping("/user/{id}")
	public Optional<User> getById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@RequestMapping("/users")
	public List<User> getAll() {
		return service.findAll();
	}
	
	@PostMapping("/users/create")
	public ApiResponse save(User user) {		
		User savedUser = service.save(user);
		
		if(savedUser != null) {
			return ApiResponse.CreateSuccess(savedUser, UserMessages.USER_SUCCESSFULLY_SAVED);
		}
		
		return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_SAVE);
	} 
	
	@PostMapping("/users/update")
	public ApiResponse update(User user) {
		User updatedUser = service.update(user);
		
		if(updatedUser != null) {
			return ApiResponse.CreateSuccess(updatedUser, UserMessages.USER_SUCCESFULLY_UPDATED);
		}
		
		return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public ApiResponse deleteById(@PathVariable final int id) throws Exception {
		int result = service.deleteById(id);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, UserMessages.USER_SUCCESSFULLY_DELETED);
		}
		
		return ApiResponse.CreateError(UserMessages.GENERIC_UNSUCCESSFUL_DELETE);
	}
}
