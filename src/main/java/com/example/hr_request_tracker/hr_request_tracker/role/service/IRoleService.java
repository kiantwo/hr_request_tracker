package com.example.hr_request_tracker.hr_request_tracker.role.service;

import com.example.hr_request_tracker.hr_request_tracker.role.model.Role;

public interface IRoleService {
	public String findById(final int id);
	public String findAll();
	public int save(final Role role);
	public int update(final Role role);
	public int deleteById(final int id);
}