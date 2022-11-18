package com.example.hr_request_tracker.hr_request_tracker.ticket.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
	@Modifying
	@Query("update Ticket t set t.assignee = :assignee where t.ticketID = :id")
	public Integer updateAssignee(@Param("id") Integer id, @Param("assignee") User assignee);
	
	@Modifying
	@Query("update Ticket t set t.status = :status where t.ticketID = :id")
	public Integer updateStatus(@Param("id") Integer id, @Param("status") Status status);
}
