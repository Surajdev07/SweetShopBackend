package com.onlinesweetshopapi.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetshopapi.domain.Customer;
import com.onlinesweetshopapi.exception.CustomerIdException;
import com.onlinesweetshopapi.service.CustomerService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("/add")
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Customer createdCustomer= customerService.saveOrUpdate(customer);
		return new ResponseEntity<Customer>(createdCustomer, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable String customerId) {
		Customer customer = customerService.findCustomerByCustomerId(customerId);
		if(customer==null)
		{
			throw new CustomerIdException("CustomerId "+customerId.toUpperCase() +" does not exist");
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Customer> getAllCustomers(){
		return customerService.findAllCustomers();
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable String customerId){
		customerService.deleteCustomerByCustomerId(customerId);
		return new ResponseEntity<String>("Customer With id : "+customerId.toUpperCase()+" is deleted successfully",HttpStatus.OK);
	}
	
	@PatchMapping("/{customerId}/{isloggedIn}")
	public ResponseEntity<?> updateCustomer(@Valid @PathVariable String customerId,@PathVariable int isloggedIn) {
		customerService.updateByCustomerId(customerId, isloggedIn);
		Customer customer = customerService.findCustomerByCustomerId(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
}
