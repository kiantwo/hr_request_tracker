package com.example.hr_request_tracker.hr_request_tracker.ticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.ticket.messages.TicketMessages;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.service.ITicketService;


//@CrossOrigin(origins= {"http://localhost:4200/"})
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
	public ApiResponse save(Ticket ticket)  {
		Ticket savedTicket = service.save(ticket);

		if (savedTicket != null) {
			return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@PostMapping("/tickets/update")
	public ApiResponse update(Ticket ticket) {
		Ticket updatedTicket = service.update(ticket);
		
		if(updatedTicket != null) {
			return ApiResponse.CreateSuccess(updatedTicket, TicketMessages.TICKET_SUCCESFULLY_UPDATED);
		}
		
		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_SAVE);
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
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}