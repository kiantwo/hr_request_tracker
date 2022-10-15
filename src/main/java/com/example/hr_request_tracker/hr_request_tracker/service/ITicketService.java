package com.example.hr_request_tracker.hr_request_tracker.service;

import java.io.BufferedReader;

import com.example.hr_request_tracker.hr_request_tracker.model.Ticket;

public interface ITicketService {
	public String findById(final int id);
	public String findAll();
	public int save(final BufferedReader body);
	public int update(final Ticket ticket);
	public int updateAssignee(final String assignee);
	public int updateStatus(final String status);
	public int deleteById(final int id);
}
