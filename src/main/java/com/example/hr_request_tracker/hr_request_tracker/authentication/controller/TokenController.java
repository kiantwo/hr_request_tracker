package com.example.hr_request_tracker.hr_request_tracker.authentication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_request_tracker.hr_request_tracker.authentication.messages.TokenMessages;
import com.example.hr_request_tracker.hr_request_tracker.authentication.model.Token;
import com.example.hr_request_tracker.hr_request_tracker.authentication.service.ITokenService;
import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;

@RestController
public class TokenController {
	@Autowired
	private ITokenService service;
	
	@RequestMapping("/token/{id}")
	public Optional<Token> getById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@RequestMapping("/authenticate/{userId}")
	public Optional<Token> authenticate(@PathVariable int userId) {
		return service.authenticate(userId);
	}
	
	@PostMapping("/token/create")
	public ApiResponse save(Token token) {
		Token savedToken = service.save(token);
		
		if(savedToken != null) {
			return ApiResponse.CreateSuccess(savedToken, TokenMessages.TOKEN_SUCCESSFULLY_SAVED);
		}
		
		return ApiResponse.CreateError(TokenMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@DeleteMapping("/token/delete/{id}")
	public ApiResponse delete(@PathVariable int id) throws Exception {
		int result = service.delete(id);
		
		if(result == 1) {
			return ApiResponse.CreateSuccess(result, TokenMessages.TOKEN_SUCCESSFULLY_DELETED);
		}
		
		return ApiResponse.CreateError(TokenMessages.GENERIC_UNSUCCESSFUL_DELETE);
	}
}
