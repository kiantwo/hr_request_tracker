//package com.example.hr_request_tracker.hr_request_tracker.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.hr_request_tracker.hr_request_tracker.model.Role;
//import com.example.hr_request_tracker.hr_request_tracker.repository.IRoleRepository;
//import com.google.gson.Gson;
//
//@Service
//public class RoleService implements IRoleService{
//	private IRoleRepository repository;
//	private Gson gson;
//	
//	@Autowired
//	public RoleService (final IRoleRepository repository) {
//		this.repository = repository;
//		this.gson = new Gson();			
//	}
//
//	public String findById(int id) {
//		return gson.toJson(repository.findById(id));
//	}
//
//	public String findAll() {
//		return gson.toJson(repository.findAll());
//	}
//
//	public int save(Role role) {
//		return repository.save(role);
//	}
//
//	public int update(Role role) {
//		return repository.updateByID(role);
//	}
//
//	public int deleteById(int id) {
//		return repository.deleteByID(id);
//	}
//	
//	
//}
