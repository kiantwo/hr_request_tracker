package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;



public class TicketRepository implements ITicketRepository{
	@Autowired
	private JdbcTemplate template;


	public Ticket findById(int id) {
		try {
		final String sql = "SELECT * from ticket_module where ticketid=?";
		final Ticket result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Ticket.class), id);
		
		return result;
		}catch(final EmptyResultDataAccessException e) {
			return new Ticket(0, "", "", "", "", "");
		}
	}


	public List<Ticket> findAll() {
		final String sql = "SELECT * from ticket_module";
		final List<Ticket> result = template.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return result;
	}


	public int save(Ticket ticket) {
		final String sql = "INSERT INTO ticket_module (ticketid,asignee,status,subject,description,tracker) VALUES (?, ?, ?, ?, ?)";
		final int result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getStatus(),ticket.getSubject(),ticket.getDescription(),ticket.getTracker());
		
		return result;
	}

	public int updateByID(Ticket ticket) {
		final String sql = "UPDATE ticket_module SET ticketid=?, asignee=?, status=?, subject=?, description=?, tracker=?";
		final int result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getStatus(),ticket.getSubject(),ticket.getDescription(),ticket.getTracker());
		
		return result;
	}


	public int deleteByID(int id) {
		final String sql = "DELETE * from ticket_module where ticketid=?";
		final int result = template.update(sql,id);
		return result;
	}

	@Override
	public int updateAssignee(int id, String assignee) {
		final String sql = "UPDATE ticket_module SET asignee=? WHERE ticketid=?";
		final int result = template.update(sql,assignee,id);
		return result;
	}

	@Override
	public int updateStatus(int id, String status) {
		final String sql = "UPDATE ticket_module SET status=? WHERE ticketid=?";
		final int result = template.update(sql,status,id);
		return result;
	}
	
	
}