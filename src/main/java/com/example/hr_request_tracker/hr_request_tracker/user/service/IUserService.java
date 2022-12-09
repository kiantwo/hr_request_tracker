package com.example.hr_request_tracker.hr_request_tracker.user.service;

import java.util.List;
import java.util.Optional;

import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

public interface IUserService {
	public Optional<User> findById(Integer id);
	public Optional<User> findByEmail(String email);
	public User login(String username, String password);
	public List<User> findAll();
	public User save(User user);
	public User update(User user);
	public Integer updatePassword(Integer id, String password);
	public Integer deleteById(Integer id) throws Exception;
}
