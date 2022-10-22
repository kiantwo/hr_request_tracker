package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.hr_request_tracker.hr_request_tracker.model.TicketType;

public class TicketTypeRepository implements ITicketTypeRepository{

	private JdbcTemplate template;
	@Override
	public TicketType findById(int id) {
		try {
		final String sql = "SELECT * from ticketType where ticketTypeID=?";
		final TicketType result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(TicketType.class), id);
		
		return result;
		}catch(final EmptyResultDataAccessException e) {
			return new TicketType(0, "", "");
		}
	}

	@Override
	public List<TicketType> findAll() {
		final String sql = "SELECT * from ticketType";
		final List<TicketType> result = template.query(sql, BeanPropertyRowMapper.newInstance(TicketType.class));
		return result;
	}

	@Override
	public int save(TicketType ticketType) {
		final String sql = "INSER INTO ticketType(ticketTypeID, typeName, description) VALUES (?,?,?)";
		final int result = template.update(sql, ticketType.getTicketTypeID(), ticketType.getTicketTypeName(),ticketType.getTicketTypeDesc());
		
		return result;
	}

	@Override
	public int updateByID(TicketType ticketType) {
		final String sql = "UPDATE role SET ticketTypeID=?, typeName=?, description=? WHERE ticketTypeID=?";
		final int result = template.update(sql, ticketType.getTicketTypeID(), ticketType.getTicketTypeName(),ticketType.getTicketTypeDesc());
		
		return result;
	}

	@Override
	public int deleteByID(int id) {
		final String sql = "DELETE from ticket_type where type_id=?";
		final int result = template.update(sql,id);
		return result;
	}
	
}