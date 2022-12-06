package com.example.hr_request_tracker.hr_request_tracker.authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.hr_request_tracker.hr_request_tracker.authentication.model.Token;
import com.example.hr_request_tracker.hr_request_tracker.authentication.repository.ITokenRepository;

@Service
public class TokenService implements ITokenService {
	@Autowired
	private ITokenRepository repository;
	
	public Optional<Token> findById(final int id) {
		return repository.findById(id);
	}
	
	public Optional<Token> authenticate(final int id) {
		return repository.findTopByUserUserIDOrderByTokenIDDesc(id);
	}
	
	public Token save(Token token) {
		return repository.save(token);
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
