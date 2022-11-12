package com.example.hr_request_tracker.hr_request_tracker.status.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Integer> {

}
