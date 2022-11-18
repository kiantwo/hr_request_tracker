package com.example.hr_request_tracker.hr_request_tracker.ticket_type.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Entity
@Table(name="ticket_type")
public class TicketType {
	@Id
	@Column(name="type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketTypeID;
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "tracker", cascade = CascadeType.ALL)
	private Set<Ticket> tickets;
	
	@ManyToMany(mappedBy="assignedTicketType")
	private Set<User> defaultAssignee;
	
	public int getTicketTypeID() {
		return this.ticketTypeID;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public String getDescription() {
		return this.description;
	}
		
	public Set<User> getDefaultAssignee() {
		return this.defaultAssignee;
	}
	
	public void setTicketTypeID(int ticketTypeID) {
		this.ticketTypeID = ticketTypeID;
	}
	
	public void setTicketTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public void setTicketTypeDescription(String description) {
		this.description = description;
	}	
}
