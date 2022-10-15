package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;



public class TicketRepository implements ITicketRepository{
	
	private JdbcTemplate template;

	@Override
	public Ticket findById(int id) {
		try {
		final String sql = "SELECT * from hr_request where ticketid=?";
		final Ticket result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Ticket.class), id);
		
		return result;
		}catch(final EmptyResultDataAccessException e) {
			return new Ticket(0, "", "", "", "", "");
		}
	}

	@Override
	public List<Ticket> findAll() {
		final String sql = "SELECT * from hr_request";
		final List<Ticket> result = template.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return result;
	}

	@Override
	public int save(Ticket user) {

		return 0;
	}

	@Override
	public int updateByID(Ticket user) {
		
		return 0;
	}

	@Override
	public int deleteByID(int id) {
		final String sql = "DELETE * from hr_request where ticketid=?";
		final Ticket result = template.qu
		return result;
	}
	
	
}