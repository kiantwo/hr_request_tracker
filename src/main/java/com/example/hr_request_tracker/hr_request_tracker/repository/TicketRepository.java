package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;



public class TicketRepository implements ITicketRepository{
	
	private JdbcTemplate template;

	@Override
	public Ticket findById(int id) {
		try {
		final String sql = "SELECT * from ticket_module where ticketid=?";
		final Ticket result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Ticket.class), id);
		
		return result;
		}catch(final EmptyResultDataAccessException e) {
			return new Ticket(0, "", "", "", "", "");
		}
	}

	@Override
	public List<Ticket> findAll() {
		final String sql = "SELECT * from ticket_module";
		final List<Ticket> result = template.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return result;
	}

	@Override
	public int save(Ticket ticket) {
		try {
		final String sql = "INSERT INTO ticket_module (ticketID, assignee, status, subject, description, tracker) Values (?,?,?,?,?,?)";
		final int result = template.update(sql,ticket.getTicketID(),ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(), ticket.getDescription(), ticket.getTracker());
		
		return result;
		}catch (DataAccessException e) {
			System.out.println ("ERROR!! :" + e);
			return 0;
		}
	}

	@Override
	public int updateByID(Ticket ticket) {
		
		return 0;
	}

	@Override
	public int deleteByID(int id) {
		final String sql = "DELETE * from ticket_module where ticketid=?";
		final int result = template.update(sql, id);
		return result;
	}
	
	
}