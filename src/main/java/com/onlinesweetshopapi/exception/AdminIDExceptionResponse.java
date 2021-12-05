package com.onlinesweetshopapi.exception;

public class AdminIDExceptionResponse {
	private String userId;
	
	public AdminIDExceptionResponse(String userId) {
	super();
	this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
