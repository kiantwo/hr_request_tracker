package com.example.hr_request_tracker.hr_request_tracker.user.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	public Page<Ticket> findAllByUserID(Integer id, Pageable page);
	
	@Query("select t from Ticket t where t.assignee = :user and t.createdAt < CURDATE()")
	public List<Ticket> findUserAgingTickets(@Param("user") User user);
	
	@Query("select t from Ticket t where t.createdAt < CURDATE()")
	public List<Ticket> findAllAgingTickets();
	
	@Query("select u from User u where u.username = :username and u.password = :password")
	public User login(@Param("username") String username, @Param("password") String password);
}
