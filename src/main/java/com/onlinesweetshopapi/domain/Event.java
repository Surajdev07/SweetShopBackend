package com.onlinesweetshopapi.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@NotBlank(message="customerIdentifier is required")
	@Size(min = 4, max = 6 , message ="Size must be between 4 to 6 characters")
	private String customerIdentifier;
	@NotBlank(message="eventName is required")
	private String eventName;
	@NotBlank(message="description is required")
	private String description;
	@NotBlank(message="start_date is required in format YYYY-MM-DD")
	private Date start_date;
	@NotBlank(message="end_date is required in format YYYY-MM-DD")
	private Date end_date;
	@NotBlank(message="event status is required")
	private String event_status;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id",nullable = false)
	@JsonIgnore
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public Event(){
		super();
	}
	
	
	public String getEvent_status() {
		return event_status;
	}
	public void setEvent_status(String event_status) {
		this.event_status = event_status;
	}
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getCustomerIdentifier() {
		return customerIdentifier;
	}
	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}
	
	
	
}

