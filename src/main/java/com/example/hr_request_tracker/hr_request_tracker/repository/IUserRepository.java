package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.io.BufferedReader;

import com.example.hr_request_tracker.hr_request_tracker.model.User;

public interface IUserRepository {
	public String findById(final int id);
	public String findAll();
	public int save(final BufferedReader body);
	public int update(final User user);
	public int deleteById(final int id);
}
