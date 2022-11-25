package com.example.hr_request_tracker.hr_request_tracker.ticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.messages.TicketMessages;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.service.ITicketService;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;


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
	
	@RequestMapping("/tickets/aging")
	public List<Ticket> getByAging() {
		return service.findByAging();
	}
	
	@RequestMapping("/tickets/aging/{category}")
	public List<Ticket> getByAgingCategory(@PathVariable TicketType category) {
		return service.findByAgingCategory(category);
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
		
		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@PostMapping("/tickets/update/assignee/{id}")
	public ApiResponse updateAssignee(@PathVariable Integer id, @RequestParam("assignee") User assignee) {
		int result = service.updateAssignee(id, assignee);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESFULLY_UPDATED);
		}
		
		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@PostMapping("/tickets/update/status/{id}")
	public ApiResponse updateStatus(@PathVariable Integer id, @RequestParam("status") Status status) {
		int result = service.updateStatus(id, status);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESFULLY_UPDATED);
		}
		
		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@DeleteMapping("/tickets/delete/{id}")
	public ApiResponse delete(@PathVariable Integer id) throws Exception {
		int result = service.delete(id);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFULLY_DELETED);
		}
		
		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_DELETE);
	}
}