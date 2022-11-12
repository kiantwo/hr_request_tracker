package com.example.hr_request_tracker.hr_request_tracker.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
//	public int updateByID(Ticket ticket);
//	public int updateAssignee(int id, String assignee);
//	public int updateStatus(int id, String status);
//	public int deleteByID(int id);
}
