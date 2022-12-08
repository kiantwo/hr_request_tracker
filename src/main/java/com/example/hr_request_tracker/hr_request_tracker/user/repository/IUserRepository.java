package com.example.hr_request_tracker.hr_request_tracker.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.username <> 'admin'")
	public List<User> findAllByUsernameNotAdmin();
		
	@Query("select u from User u where u.username = :username or u.email = :username and u.password = :password")
	public User login(@Param("username") String username, @Param("password") String password);
}
