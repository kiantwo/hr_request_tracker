package com.example.hr_request_tracker.hr_request_tracker.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.service.ITicketService;

@RestController
public class TicketController {
	private ITicketService service;
	
	@Autowired
	public TicketController(final ITicketService service) {
		this.service = service;
	}
	
	@RequestMapping("/ticket/{id}")
	public String getById(@PathVariable final int id) {
		return service.findById(id);
	}
	
	@RequestMapping("/tickets")
	public String getAll() {
		return service.findAll();
	}
	
	@PostMapping("/tickets")
	public int save(final HttpServletRequest request) throws IOException {
		final BufferedReader body = request.getReader();
		
		if(service.save(body) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {
			return 1;
		}
	}
	
	@PostMapping("/tickets/update/{id}")
	public int update(@PathVariable final int id, 
			@RequestParam("assignee") final String assignee,
			@RequestParam("status") final String status,
			@RequestParam("subject") final String subject,
			@RequestParam("description") final String description,
			@RequestParam("tracker") final String tracker) throws IOException {
		
		if(service.update(new Ticket(id, assignee, status, subject, description, tracker)) <= 0) {
			throw new IOException("Something went wrong in the database");
		} else {
			return 1;
		}
	}
	
	@PostMapping("/tickets/update/assignee/{id}")
	public int updateAssignee(@PathVariable final int id, 
			@RequestParam("assignee") final String assignee) throws IOException {
		if(service.updateAssignee(assignee) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {
			return 1;
		}
	}
	
	@PostMapping("/tickets/update/status/{id}")
	public int updateStatus(@PathVariable final int id, 
			@RequestParam("status") final String status) throws IOException {
		if(service.updateStatus(status) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {		
			return 1;
		}
	}
	
	@DeleteMapping("/tickets/delete/{id}")
	public int deleteById(@PathVariable final int id) throws IOException {
		if(service.deleteById(id) <= 0) {
			throw new IOException("Something went wrong in the database.");
		} else {	
			return 1;
		}
	}
}
