package com.example.hr_request_tracker.hr_request_tracker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.service.ITicketTypeService;

@RestController
public class TicketTypeController {
	private ITicketTypeService service;
	
	@Autowired
	public TicketTypeController(final ITicketTypeService service) {
		this.service = service;
	}
	
	@RequestMapping("/ticket-type/{id}")
	public String getByID(@PathVariable final int id) {
		return service.findById(id);
	}
	
	@RequestMapping("/ticket-types")
	public String getAll() {
		return service.findAll();
	}
		
	@PostMapping("/ticket-types")
	public int save(@RequestParam("type_id") final int id, 
			@RequestParam("type_name") final String typeName, 
			@RequestParam("description") final String description) throws IOException {		
		if(service.save(new TicketType(id, typeName, description)) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {
			return 1;
		}
	}
	
	@PostMapping("/ticket-types/update/{id}")
	public int update(@PathVariable final int id, 
			@RequestParam("type_name") final String typeName, 
			@RequestParam("description") final String description) throws IOException {
		
		if(service.update(new TicketType(id, typeName, description)) <= 0) {
			throw new IOException("Something went wrong in the database");
		} else {
			return 1;
		}
	}
	
	@DeleteMapping("/ticket-types/delete/{id}")
	public int deleteById(@PathVariable final int id) throws IOException {
		if(service.deleteById(id) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {	
			return 1;
		}
	}
}
