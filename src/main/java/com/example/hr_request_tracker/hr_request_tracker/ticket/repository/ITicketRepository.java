package com.example.hr_request_tracker.hr_request_tracker.ticket.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hr_request_tracker.hr_request_tracker.status.model.Status;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IAgingTicket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.ITicketCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IUserCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
	public Page<Ticket> findAll(Pageable pageable);
	
	public Page<Ticket> findAllByAssigneeUserID(Integer id, Pageable page);
	
	public Page<Ticket> findAllByStatusStatusID(Integer ID, Pageable page);
	
	@Query("select t from Ticket t where t.assignee = :user and t.createdAt < CURDATE() and t.status = 400")
	public Page<Ticket> findUserAgingTickets(@Param("user") User user, Pageable pageable);
	
	@Query("select t from Ticket t where t.createdAt < CURDATE() and t.status = 400")
	public Page<Ticket> findAllAgingTickets(Pageable page);
		
	@Modifying
	@Query("update Ticket t set t.assignee = :assignee where t.ticketID = :id")
	public Integer updateAssignee(@Param("id") Integer id, @Param("assignee") User assignee);
	
	@Modifying
	@Query("update Ticket t set t.status = :status where t.ticketID = :id")
	public Integer updateStatus(@Param("id") Integer id, @Param("status") Status status);
	
	@Query("select t from Ticket t where t.createdAt < CURDATE()")
	public List<Ticket> findByAging();
	
	@Query("select t.ticketID as ticketID, t.status as status, t.tracker as tracker, t.createdAt as createdAt " + "from Ticket as t group by t.ticketID, t.tracker having t.status = 400 and t.createdAt < CURDATE()")
	public List<IAgingTicket> findByAgingCategory();
	
	@Query("select t.tracker as tracker, count(t.tracker) as trackerCount " + "from Ticket as t group by t.tracker")
	public List<ITicketCount> findByCountCategory();
	
	@Query("select t.assignee as user, count(t.assignee) as userCount " + "from Ticket as t group by t.assignee")
	public List<IUserCount> findByCountUser();
}
