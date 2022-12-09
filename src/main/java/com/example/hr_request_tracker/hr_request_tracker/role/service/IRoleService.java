package com.example.hr_request_tracker.hr_request_tracker.role.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.role.model.Role;

public interface IRoleService {
	public Optional<Role> findById(final int id);
	public List<Role> findAll();
	public Role save(final Role role);
	public Role update(final Role role);
	public Integer delete(final int id) throws Exception;
}