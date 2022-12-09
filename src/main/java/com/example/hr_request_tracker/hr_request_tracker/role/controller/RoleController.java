package com.example.hr_request_tracker.hr_request_tracker.role.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.role.messages.RoleMessages;
import com.example.hr_request_tracker.hr_request_tracker.role.model.Role;
import com.example.hr_request_tracker.hr_request_tracker.role.service.IRoleService;

@RestController
public class RoleController {
	@Autowired
	private IRoleService service;
	
	@RequestMapping("/role/{id}")
	public Optional<Role> getByID(@PathVariable int id) {
		return service.findById(id);
	}
	
	@RequestMapping("/roles")
	public List<Role> getAll() {
		return service.findAll();
	}
	
	@PostMapping("/roles/create")
	public ApiResponse save(Role role)  {
		Role savedRole= service.save(role);

		if (savedRole != null) {
			return ApiResponse.CreateSuccess(savedRole, RoleMessages.ROLE_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(RoleMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@PostMapping("/roles/update")
	public ApiResponse update(Role role) {
		Role updatedRole = service.update(role);
		
		if(updatedRole != null) {
			return ApiResponse.CreateSuccess(updatedRole, RoleMessages.ROLE_SUCCESFULLY_UPDATED);
		}
		
		return ApiResponse.CreateError(RoleMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@DeleteMapping("/roles/delete/{id}")
	public ApiResponse delete(@PathVariable Integer id) throws Exception {
		int result = service.delete(id);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, RoleMessages.ROLE_SUCCESSFULLY_DELETED);
		}
		
		return ApiResponse.CreateError(RoleMessages.GENERIC_UNSUCCESSFUL_DELETE);
	}
}
