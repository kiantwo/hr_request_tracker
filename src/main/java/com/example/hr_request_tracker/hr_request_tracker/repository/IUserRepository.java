package com.example.hr_request_tracker.hr_request_tracker.repository;

import java.util.List;

import com.example.hr_request_tracker.hr_request_tracker.model.User;

public interface IUserRepository {
	public User findById(final int id);
	public List<User> findAll();
	public int save(final User user);
	public int updateByID(final User user);
	public int deleteByID(final int id);	
}
