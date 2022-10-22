package com.example.hr_request_tracker.hr_request_tracker.service;

import com.example.hr_request_tracker.hr_request_tracker.model.User;

public interface IUserService {
	public String findById(final int id);
	public String findAll();
	public int save(final User user);
	public int update(final User user);
	public int deleteById(final int id);
}
