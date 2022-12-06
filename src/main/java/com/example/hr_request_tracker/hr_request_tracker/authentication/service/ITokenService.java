package com.example.hr_request_tracker.hr_request_tracker.authentication.service;

import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.authentication.model.Token;

public interface ITokenService {
	public Optional<Token> findById(final int id);
	public Optional<Token> authenticate(final int id);
	public Token save(Token token);
	public Integer delete(final int id) throws Exception;
}
