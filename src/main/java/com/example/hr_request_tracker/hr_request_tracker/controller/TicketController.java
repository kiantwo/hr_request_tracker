package com.example.hr_request_tracker.hr_request_tracker.controller;

import java.util.List;
import java.util.Optional;

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
	@Autowired
	private ITicketService service;
		
	@RequestMapping("/ticket/{id}")
	public Optional<Ticket> getById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@RequestMapping("/tickets")
	public List<Ticket> getAll() {
		return service.findAll();
	}
	
	@PostMapping("/tickets/create")
	public Ticket save(Ticket ticket)  {
		return service.save(ticket);
	}
	
	@PostMapping("/tickets/update")
	public Ticket update(Ticket ticket) {
		return service.update(ticket);
	}
	
//	@PostMapping("/tickets/update/assignee/{id}")
//	public int updateAssignee(@PathVariable int id, @RequestParam("assignee") String assignee) {
//		return service.updateAssignee(id, assignee);
//	}
//	
//	@PostMapping("/tickets/update/status/{id}")
//	public int updateStatus(@PathVariable int id, @RequestParam("status") String status) {
//		return service.updateStatus(id, status);
//	}
	
	@DeleteMapping("/tickets/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}
}