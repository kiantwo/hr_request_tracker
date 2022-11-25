package com.example.hr_request_tracker.hr_request_tracker.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
	@Modifying
	@Query("update Ticket t set t.assignee = :assignee where t.ticketID = :id")
	public Integer updateAssignee(@Param("id") Integer id, @Param("assignee") User assignee);
	
	@Modifying
	@Query("update Ticket t set t.status = :status where t.ticketID = :id")
	public Integer updateStatus(@Param("id") Integer id, @Param("status") Status status);
	
	@Query("select t from Ticket t where t.createdAt < CURDATE()")
	public List<Ticket> findByAging();
	
	@Query("select t from Ticket t where t.tracker = :category and t.createdAt < CURDATE()")
	public List<Ticket> findByAgingCategory(@Param("category") TicketType category);
}
