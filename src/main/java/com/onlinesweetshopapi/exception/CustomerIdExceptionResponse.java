package com.onlinesweetshopapi.exception;

public class CustomerIdExceptionResponse {

	private String customerId;

	public CustomerIdExceptionResponse(String customerId) {
		super();
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
