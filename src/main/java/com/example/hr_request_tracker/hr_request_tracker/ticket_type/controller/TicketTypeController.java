package com.example.hr_request_tracker.hr_request_tracker.ticket_type.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.service.ITicketTypeService;

@RestController
public class TicketTypeController {
	@Autowired
	private ITicketTypeService service;
	
	@RequestMapping("/ticket-type/{id}")
	public Optional<TicketType> getByID(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@RequestMapping("/ticket-types")
	public List<TicketType> getAll() {
		return service.findAll();
	}
		
//	@PostMapping("/ticket-types")
//	public int save(@RequestParam("type_id") final int id, 
//			@RequestParam("type_name") final String typeName, 
//			@RequestParam("description") final String description) throws IOException {		
//		if(service.save(new TicketType(id, typeName, description)) <= 0) {
//			throw new IOException("Something went wrong in the database.");
//		} else {
//			return 1;
//		}
//	}
//	
//	@PostMapping("/ticket-types/update/{id}")
//	public int update(@PathVariable final int id, 
//			@RequestParam("type_name") final String typeName, 
//			@RequestParam("description") final String description) throws IOException {
//		
//		if(service.update(new TicketType(id, typeName, description)) <= 0) {
//			throw new IOException("Something went wrong in the database");
//		} else {
//			return 1;
//		}
//	}
	
//	@DeleteMapping("/ticket-types/delete/{id}")
//	public int deleteById(@PathVariable final int id) throws IOException {
//		if(service.deleteById(id) <= 0) {
//			throw new IOException("Something went wrong in the database.");
//		} else {	
//			return 1;
//		}
//	}
}
