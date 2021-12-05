package com.onlinesweetshopapi.exception;

public class OrderIDExceptionResponse {
	private String orderId;
public OrderIDExceptionResponse(String orderId) {
	super();
	this.orderId = orderId;
	
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String userId) {
	this.orderId = userId;
}
}
