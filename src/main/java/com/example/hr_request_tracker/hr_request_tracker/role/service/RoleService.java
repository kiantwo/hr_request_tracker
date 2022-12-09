package com.example.hr_request_tracker.hr_request_tracker.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.role.model.Role;
import com.example.hr_request_tracker.hr_request_tracker.role.repository.IRoleRepository;


@Service
public class RoleService implements IRoleService{
	@Autowired
	private IRoleRepository repository;
	
	public Optional<Role> findById(final int id) {
		return repository.findById(id);
	}
	
	public List<Role> findAll() {
		return repository.findAll();
	}
	
	public Role save(final Role role) {
		return repository.save(role);
	}
	
	public Role update(final Role role) {
		return repository.save(role);
	}
	
	public Integer delete(final int id) throws Exception {
		try {
			repository.deleteById(id);
			return 1;
		} catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
	
}
