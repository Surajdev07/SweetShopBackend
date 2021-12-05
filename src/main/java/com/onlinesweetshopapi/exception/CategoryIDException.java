package com.onlinesweetshopapi.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryIDException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryIDException()
	 {
		 super();
	 }
	 
	 public CategoryIDException(String errMsg) {
		 super(errMsg);
		 
	 }

}
