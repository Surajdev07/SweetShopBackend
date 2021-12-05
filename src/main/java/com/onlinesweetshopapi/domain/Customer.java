package com.onlinesweetshopapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
public class Customer {
	
	//userId, name, id, password, emailId, order, event
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message="customer Name is Required")
	private String customerName;
	@NotBlank(message="customer Id is Required")
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 character")
	@Column(unique = true,updatable = false)
	private String customerId;
	@NotBlank(message="customer Password is Required")
	private String customerPassword;
	@NotBlank(message="customer Email is Required")
	private String customerEmail;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "customer")
	private List<Order> order= new ArrayList<Order>();
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "customer")
	private Event event;
	private int isloggedIn;
	
	
	
	

	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public int getIsloggedIn() {
		return isloggedIn;
	}
	public void setIsloggedIn(int isloggedIn) {
		this.isloggedIn = isloggedIn;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", customerPassword="
				+ customerPassword + ", customerEmail=" + customerEmail + "]";
	}
	
	
	
}
