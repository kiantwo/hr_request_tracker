package com.example.hr_request_tracker.hr_request_tracker.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.model.User;
import com.example.hr_request_tracker.hr_request_tracker.service.IUserService;

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
	
//	@PostMapping("/users")
//	public int save() throws IOException {		
//		if(service.save(new User()) <= 0) {
//			throw new IOException("Something went wrong in the database.");
//		} else {
//			return 1;
//		}
//	}
//	
//	@PostMapping("/users/update/{id}")
//	public int update(@PathVariable final int id) throws IOException {
//		
//		if(service.update(new User()) <= 0) {
//			throw new IOException("Something went wrong in the database");
//		} else {
//			return 1;
//		}
//	}
//	
//	@DeleteMapping("/users/delete/{id}")
//	public int deleteById(@PathVariable final int id) throws IOException {
//		if(service.deleteById(id) <= 0) {
//			throw new IOException("Something went wrong in the database.");
//		} else {	
//			return 1;
//		}
//	}
}
