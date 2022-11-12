package com.example.hr_request_tracker.hr_request_tracker.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
