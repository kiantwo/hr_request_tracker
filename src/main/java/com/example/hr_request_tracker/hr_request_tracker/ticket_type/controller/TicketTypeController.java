package com.example.hr_request_tracker.hr_request_tracker.ticket_type.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.messages.TicketTypeMessages;
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
		
	@PostMapping("/ticket-types/create")
	public ApiResponse save(TicketType ticketType) {		
		TicketType savedTicket = service.save(ticketType);
		
		if(savedTicket != null) {
			return ApiResponse.CreateSuccess(savedTicket, TicketTypeMessages.TICKET_TYPE_SUCCESSFULLY_SAVED);
		}
		
		return ApiResponse.CreateError(TicketTypeMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@PostMapping("/ticket-types/update")
	public ApiResponse update(TicketType ticketType) {
		TicketType updatedTicket = service.update(ticketType);
		
		if(updatedTicket != null) {
			return ApiResponse.CreateSuccess(updatedTicket, TicketTypeMessages.TICKET_TYPE_SUCCESFULLY_UPDATED);
		}
		
		return ApiResponse.CreateError(TicketTypeMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@DeleteMapping("/ticket-types/delete/{id}")
	public ApiResponse delete(@PathVariable final int id) throws Exception {
		int result = service.delete(id);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, TicketTypeMessages.TICKET_TYPE_SUCCESSFULLY_DELETED);
		}
		
		return ApiResponse.CreateError(TicketTypeMessages.GENERIC_UNSUCCESSFUL_DELETE);
	}
}
