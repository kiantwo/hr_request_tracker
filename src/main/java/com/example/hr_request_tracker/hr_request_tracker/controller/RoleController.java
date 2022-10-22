package com.example.hr_request_tracker.hr_request_tracker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.model.Role;
import com.example.hr_request_tracker.hr_request_tracker.service.IRoleService;

@RestController
public class RoleController {
	private IRoleService service;
	
	@Autowired
	public RoleController(final IRoleService service) {
		this.service = service;
	}
	
	@RequestMapping("/role/{id}")
	public String getByID(@PathVariable final int id) {
		return service.findById(id);
	}
	
	@RequestMapping("/roles")
	public String getAll() {
		return service.findAll();
	}
	
	@PostMapping("/roles")
	public int save(@RequestParam("role_id") final int id, 
			@RequestParam("role") final String role, 
			@RequestParam("role_abbv") final String roleAbbv) throws IOException {		
		if(service.save(new Role(id, role, roleAbbv)) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {
			return 1;
		}
	}
	
	@PostMapping("/roles/update/{id}")
	public int update(@PathVariable final int id, 
			@RequestParam("role") final String role, 
			@RequestParam("role_abbv") final String roleAbbv) throws IOException {
		
		if(service.update(new Role(id, role, roleAbbv)) <= 0) {
			throw new IOException("Something went wrong in the database");
		} else {
			return 1;
		}
	}
	
	@DeleteMapping("/roles/delete/{id}")
	public int deleteById(@PathVariable final int id) throws IOException {
		if(service.deleteById(id) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {	
			return 1;
		}
	}
}
