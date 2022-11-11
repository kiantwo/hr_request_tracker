//package com.example.hr_request_tracker.hr_request_tracker.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;
//
//@Repository
//public abstract class TicketRepository implements ITicketRepository{
//	@Autowired
//	private JdbcTemplate template;
//
//	public int updateByID(Ticket ticket) {
//		final String sql = "UPDATE ticket_module SET asignee=?, status=?, subject=?, description=?, tracker=? WHERE ticketid=?";
//		final int result = template.update(sql, ticket.getAssignee(), ticket.getStatus(),ticket.getSubject(),ticket.getDescription(),ticket.getTracker(), ticket.getTicketID());
//		
//		return result;
//	}
//
//	public int deleteByID(int id) {
//		final String sql = "DELETE from ticket_module where ticketid=?";
//		final int result = template.update(sql,id);
//		return result;
//	}
//
//	public int updateAssignee(int id, String assignee) {
//		final String sql = "UPDATE ticket_module SET asignee=? WHERE ticketid=?";
//		final int result = template.update(sql,assignee,id);
//		return result;
//	}
//
//	public int updateStatus(int id, String status) {
//		final String sql = "UPDATE ticket_module SET status=? WHERE ticketid=?";
//		final int result = template.update(sql,status,id);
//		return result;
//	}
//	
//	
//}
