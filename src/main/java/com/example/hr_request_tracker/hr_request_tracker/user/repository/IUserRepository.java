package com.example.hr_request_tracker.hr_request_tracker.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	@Query("select t from Ticket t where t.assignee = :user")
	public List<Ticket> findUserTickets(@Param("user") User user);
}
