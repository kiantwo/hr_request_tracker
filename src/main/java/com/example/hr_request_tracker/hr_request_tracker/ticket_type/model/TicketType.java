package com.example.hr_request_tracker.hr_request_tracker.ticket_type.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private Set<Ticket> tickets = new HashSet<>();
	
	@ManyToMany
    @JoinTable(
            name = "user_ticket",
            joinColumns = @JoinColumn(name = "tracker_id", referencedColumnName = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "assignee_id", referencedColumnName = "user_id")
    )
	private Set<User> defaultAssignee = new HashSet<>();
	
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
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDefaultAssignee(User defaultAssignee) {
		this.defaultAssignee.add(defaultAssignee);
	}
}
