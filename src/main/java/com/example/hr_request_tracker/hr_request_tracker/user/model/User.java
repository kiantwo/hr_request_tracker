package com.example.hr_request_tracker.hr_request_tracker.user.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket_type.model.TicketType;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String username;
	@Column(name="user_fname")
	private String userFName;
	@Column(name="user_lname")
	private String userLName;
	private String password;
	private String email;
	
	@OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
	private Set<Ticket> tickets;
	
	@ManyToMany
    @JoinTable(
            name = "user_ticket",
            joinColumns = {@JoinColumn(name = "assignee_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "tracker_id", referencedColumnName = "type_id")}
    )
	private Set<TicketType> assignedTicketType;
	
	public int getUserID() {
		return this.userID;
	}
		
	public String getUsername() {
		return this.username;
	}
	
	public String getUserFName() {
		return this.userFName;
	}
	
	public String getUserLName() {
		return this.userLName;
	}
	
	public String getUserPassword() {
		return this.password;
	}
	
	public String getUserEmail() {
		return this.email;
	}
			
 	public void setUserID(final int id) {
		this.userID = id;
	}
	
	public void setUsername(final String username) {
		this.username = username;
	}
	
	public void setUserFName(final String userFName) {
		this.userFName = userFName;
	}
	
	public void setUserLName(final String userLName) {
		this.userLName = userLName;
	}
	
	public void setUserPassword(final String password) {
		this.password = password;
	}
	
	public void setUserEmail(final String email) {
		this.email = email;
	}
}
