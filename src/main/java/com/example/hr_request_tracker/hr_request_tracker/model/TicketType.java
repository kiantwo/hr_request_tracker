package com.example.hr_request_tracker.hr_request_tracker.model;

public class TicketType {
	private int ticketTypeID;
	private String typeName;
	private String description;
	
	public TicketType() {}
	
	public TicketType(final int id, final String typeName, final String description) {
		this.ticketTypeID = id;
		this.typeName = typeName;
		this.description = description;
	}
	
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
