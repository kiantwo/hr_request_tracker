package com.example.hr_request_tracker.hr_request_tracker.ticket.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.csv.service.CsvExportService;
import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.messages.TicketMessages;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IAgingTicket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.ITicketCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IUserCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.service.ITicketService;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;


//@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
public class TicketController {
	@Autowired
	private ITicketService service;
	@Autowired
	private CsvExportService csvExportService;
		
	@RequestMapping("/ticket/{id}")
	public Optional<Ticket> getById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@RequestMapping("/tickets")
	public Page<Ticket> getAll(@Param("search") String search, @Param("filter") String filter, Pageable pageable) {
		return service.findAllPageable(search, filter, pageable);
	}
	
	@RequestMapping("/tickets/aging")
	public List<Ticket> getByAging() {
		return service.findByAging();
	}
	
	@RequestMapping("/tickets/user/{id}")
	public Page<Ticket> getUserTickets(@Param("search") String search, @PathVariable Integer id, Pageable pageable) {
		return service.findAllByUserID(search, id, pageable);
	}
	
	@RequestMapping("/aging/{user}")
	public Page<Ticket> getUserAgingTickets(@PathVariable User user, Pageable pageable) {
		return service.findUserAgingTickets(user, pageable);
	}
	
	@RequestMapping("/aging")
	public Page<Ticket> getAllAgingTickets(Pageable pageable) {
		return service.findAllAgingTickets(pageable);
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
	
	@RequestMapping("/tickets/all/export")
	public void exportAllTickets(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"all_tickets.csv\"");
		csvExportService.writeAllTicketsToCsv(response.getWriter());
	}
	
	@RequestMapping("/tickets/category/aging")
	public List<IAgingTicket> getTicketsByAgingCategory() {
		return service.findByAgingCategory();
	}
		
	@RequestMapping("/tickets/category/aging/export")
	public void exportByAgingCategory(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"aging_tickets_per_category.csv\"");
		csvExportService.writeAgingCategoryToCsv(response.getWriter());
	}
	
	@RequestMapping("/tickets/category/count")
	public List<ITicketCount> getTicketsByCountCategory() {
		return service.findByCountCategory();
	}
	
	@RequestMapping("/tickets/category/count/export")
	public void exportByCountCategory(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"ticket_count_category.csv\"");
		csvExportService.writeCountCategoryToCsv(response.getWriter());
	}
	
	@RequestMapping("/tickets/user/count")
	public List<IUserCount> getTicketsByCountUser() {
		return service.findByCountUser();
	}
	
	@RequestMapping("/tickets/user/count/export")
	public void exportByCountUser(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"user_count_category.csv\"");
		csvExportService.writeCountUserToCsv(response.getWriter());
	}
}