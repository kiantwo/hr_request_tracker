package com.example.hr_request_tracker.hr_request_tracker.controller;

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
	public int save(Ticket ticket)  {
		return service.save(ticket);
	}
	
	@PostMapping("/tickets/update/{id}")
	public int update(Ticket ticket) {
		return service.update(ticket);
	}
	
	@PostMapping("/tickets/update/assignee/{id}")
	public int updateAssignee(@PathVariable final int id, @RequestParam("assignee") final String assignee) {
		return service.updateAssignee(id, assignee);
	}
	
	@PostMapping("/tickets/update/status/{id}")
	public int updateStatus(@PathVariable final int id, @RequestParam("status") final String status) {
		return service.updateStatus(id, status);
	}
	
	@DeleteMapping("/tickets/delete/{id}")
	public int deleteById(@PathVariable final int id) {
		return service.deleteById(id);
	}
}