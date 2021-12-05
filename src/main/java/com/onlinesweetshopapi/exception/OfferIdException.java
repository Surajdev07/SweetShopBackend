package com.onlinesweetshopapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OfferIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create OfferIdException object without error message
	 */
	public OfferIdException() {
		super();
	}
	/**
	 * Create OfferIdException object with error message
	 */
	public OfferIdException(String errMsg) {
		super(errMsg);
	}

}