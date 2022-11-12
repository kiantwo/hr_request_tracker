package com.example.hr_request_tracker.hr_request_tracker.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.model.User;

public interface IUserService {
	public Optional<User> findById(Integer id);
	public List<User> findAll();
	public User save(User user);
	public User update(User user);
	public void deleteById(Integer id);
}
