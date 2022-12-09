package com.example.hr_request_tracker.hr_request_tracker.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.username <> 'admin'")
	public List<User> findAllByUsernameNotAdmin();
	
	public Optional<User> findByEmail(String email);
		
	@Query("select u from User u where (u.username = :username or u.email = :username) and u.password = :password")
	public User login(@Param("username") String username, @Param("password") String password);
	
	@Modifying
	@Transactional
	@Query("update User u set u.password = :password where u.userID = :id")
	public Integer updatePassword(@Param("id") Integer id, @Param("password") String password);
}
