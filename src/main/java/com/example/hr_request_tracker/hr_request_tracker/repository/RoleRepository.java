package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.hr_request_tracker.hr_request_tracker.model.Role;

public class RoleRepository implements IRoleRepository{
	
	private JdbcTemplate template;

	public Role findById(int id) {
		try {
		final String sql = "SELECT * from role where roleID=?";
		final Role result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Role.class), id);
		
		return result;
		}catch(final EmptyResultDataAccessException e) {
			return new Role(0, "", "");
		}
	}

	public List<Role> findAll() {
		final String sql = "SELECT * from role";
		final List<Role> result = template.query(sql, BeanPropertyRowMapper.newInstance(Role.class));
		return result;
	}

	public int save(Role role) {
		final String sql = "INSERT INTO role (roleID, role, roleAbbv) VALUES (?, ?, ?)";
		final int result = template.update(sql, role.getRoleID(), role.getRole(),role.roleAbbv());
		
		return result;
	}

	public int updateByID(Role role) {
		final String sql = "UPDATE role SET roleID=?, role=?, roleAbbv=? WHERE roleID=?";
		final int result = template.update(sql, role.getRoleID(), role.getRole(),role.roleAbbv());
		
		return result;
	}

	public int deleteByID(int id) {
		final String sql = "DELETE from role where role_id=?";
		final int result = template.update(sql,id);
		return result;
	}
	
	
}