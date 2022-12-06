package com.example.hr_request_tracker.hr_request_tracker.authentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.authentication.model.Token;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Integer> {
//	@Query("select t from Token t where t.user.userID = :userId order by tokenID desc")
//	public Optional<Token> authenticate(@Param("userId") Integer userId);
	
	public Optional<Token> findTopByUserUserIDOrderByTokenIDDesc(@Param("userId") Integer userId);
}
