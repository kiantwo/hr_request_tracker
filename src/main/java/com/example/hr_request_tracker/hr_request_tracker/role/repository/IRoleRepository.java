package com.example.hr_request_tracker.hr_request_tracker.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.role.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
