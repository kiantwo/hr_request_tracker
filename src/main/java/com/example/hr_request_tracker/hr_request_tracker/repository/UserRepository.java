package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.hr_request_tracker.hr_request_tracker.model.User;

public class UserRepository implements IUserRepository{
	private JdbcTemplate template;
	@Override
	public User findById(int id) {
		try {
		final String sql = "SELECT * from user where user_id=?";
		final User result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
		
		return result;
		}catch(final EmptyResultDataAccessException e) {
			return new User(0, id, "", "", "", "", "");
		}
	}

	@Override
	public List<User> findAll() {
		final String sql = "SELECT * from user";
		final List<User> result = template.query(sql, BeanPropertyRowMapper.newInstance(User.class));
		return result;
	}

	@Override
	public int save(User user) {
		final String sql = "INSERT INTO user (user_id, role_id, username, user_fname, user_lname, password, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
		final int result = template.update(sql, user.getUserID(), user.getRoleID(), user.getUsername(), user.getUserFName(), user.getUserLName(), user.getUserPassword(), user.getUserEmail());
		
		return result;
	}

	@Override
	public int updateByID(User user) {
		final String sql = "UPDATE user SET user_id=?, role_id=?, username=?, user_fname=?, user_lname=?, password=?, email=?, WHERE ticketid=?";
		final int result = template.update(sql, user.getUserID(), user.getRoleID(), user.getUsername(), user.getUserFName(), user.getUserLName(), user.getUserPassword(), user.getUserEmail() );
		
		return result;
	}

	@Override
	public int deleteByID(int id) {
		final String sql = "DELETE from user where user_id=?";
		final int result = template.update(sql,id);
		return result;
	}
	
	
}