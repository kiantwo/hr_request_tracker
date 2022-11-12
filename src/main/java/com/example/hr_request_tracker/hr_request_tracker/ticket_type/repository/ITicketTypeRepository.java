package com.example.hr_request_tracker.hr_request_tracker.ticket_type.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;

@Repository
public interface ITicketTypeRepository extends JpaRepository<TicketType, Integer> {

}
