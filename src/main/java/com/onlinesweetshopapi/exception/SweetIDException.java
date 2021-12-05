package com.onlinesweetshopapi.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SweetIDException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SweetIDException()
	 {
		 super();
	 }
	 
	 public SweetIDException(String errMsg) {
		 super(errMsg);
		 
	 }

}
