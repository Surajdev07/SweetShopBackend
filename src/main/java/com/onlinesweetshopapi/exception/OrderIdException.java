package com.onlinesweetshopapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create OrderIdException object without error message
	 */
	public OrderIdException() {
		super();
	}
	/**
	 * Create OrderIdException object with error message
	 */
	public OrderIdException(String errMsg) {
		super(errMsg);
	}

}