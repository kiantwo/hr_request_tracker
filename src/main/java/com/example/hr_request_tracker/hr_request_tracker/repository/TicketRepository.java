package com.example.hr_request_tracker.hr_request_tracker.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;

@Repository
public class TicketRepository implements ITicketRepository{
	@Autowired
	private JdbcTemplate template;

	public Ticket findById(int id) {
		try {
		final String sql = "SELECT * from ticket where ticketid=?";
		final Ticket result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Ticket.class), id);
		
		return result;
		}catch(final EmptyResultDataAccessException e) {
			return new Ticket(0, "", "", "", "", "");
		}
	}

	public List<Ticket> findAll() {
		final String sql = "SELECT * from ticket";
		final List<Ticket> result = template.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return result;
	}

	public int save(Ticket ticket) {
		final String sql = "INSERT INTO ticket (ticketid,asignee,status,subject,description,tracker) VALUES (?, ?, ?, ?, ?, ?)";
		final int result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getStatus(),ticket.getSubject(),ticket.getDescription(),ticket.getTracker());
		
		return result;
	}

	public int updateByID(Ticket ticket) {
		final String sql = "UPDATE ticket SET asignee=?, status=?, subject=?, description=?, tracker=? WHERE ticketid=?";
		final int result = template.update(sql, ticket.getAssignee(), ticket.getStatus(),ticket.getSubject(),ticket.getDescription(),ticket.getTracker(), ticket.getTicketID());
		
		return result;
	}

	public int deleteByID(int id) {
		final String sql = "DELETE from ticket where ticketid=?";
		final int result = template.update(sql,id);
		return result;
	}

	public int updateAssignee(int id, String assignee) {
		final String sql = "UPDATE ticket SET asignee=? WHERE ticketid=?";
		final int result = template.update(sql,assignee,id);
		return result;
	}

	public int updateStatus(int id, String status) {
		final String sql = "UPDATE ticket SET status=? WHERE ticketid=?";
		final int result = template.update(sql,status,id);
		return result;
	}
	
	
}
