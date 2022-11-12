package com.example.hr_request_tracker.hr_request_tracker.ticket_type.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_type")
public class TicketType {
	@Id
	@Column(name="type_id")
	private int ticketTypeID;
	@Column(name="type_name")
	private String typeName;
	private String description;
	
	public int getTicketTypeID() {
		return this.ticketTypeID;
	} 
	
	public String getTicketTypeName() {
		return this.typeName;
	}
	
	public String getTicketTypeDesc() {
		return this.description;
	}
	
	public void setTicketTypeID(final int id) {
		this.ticketTypeID = id;
	}
	
	public void setTicketTypeName(final String typeName) {
		this.typeName = typeName;
	}
	
	public void setTicketTypeDesc(final String description) {
		this.description = description;
	}
}
