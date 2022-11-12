package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import com.example.hr_request_tracker.hr_request_tracker.model.Role;

public interface IRoleRepository {
	public Role findById(final int id);
	public List<Role> findAll();
	public int save(final Role role);
	public int updateByID(final Role role);
	public int deleteByID(final int id);
}
