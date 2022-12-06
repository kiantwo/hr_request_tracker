package com.example.hr_request_tracker.hr_request_tracker.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.file.model.File;

@Repository
public interface IFileRepository extends JpaRepository<File, Integer> {

}
