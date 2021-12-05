package com.onlinesweetshopapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleSweetIdException(SweetIDException ex,WebRequest request)
	{
		SweetIDExceptionResponse exceptionResponse = new SweetIDExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleAdminIdException(AdminIDException ex,WebRequest request)
	{
		AdminIDExceptionResponse exceptionResponse = new AdminIDExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleCustomerIdException(CustomerIdException ex,WebRequest request)
	{
		CustomerIdExceptionResponse exceptionResponse = new CustomerIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleCategoryIdException(CategoryIDException ex,WebRequest request)
	{
		CategoryIDExceptionResponse exceptionResponse = new CategoryIDExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleOfferIdException(OfferIdException ex,WebRequest request)
	{
		OfferIdExceptionResponse exceptionResponse = new OfferIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleOrderIdException(OrderIdException ex,WebRequest request)
	{
		OrderIDExceptionResponse exceptionResponse = new OrderIDExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
