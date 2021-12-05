package com.onlinesweetshopapi.exception;

public class CategoryIDExceptionResponse {

	private String categoryIdentifier;

	public CategoryIDExceptionResponse(String categoryIdentifier) {
		super();
		this.categoryIdentifier = categoryIdentifier;
	}

	public String getCategoryIdentifier() {
		return categoryIdentifier;
	}

	public void setCategoryIdentifier(String categoryIdentifier) {
		this.categoryIdentifier = categoryIdentifier;
	}
	
	
}
