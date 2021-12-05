package com.onlinesweetshopapi.service;


import javax.validation.Valid;

import com.onlinesweetshopapi.domain.Customer;


public interface CustomerService {
	public Customer saveOrUpdate(Customer customer);
	public Iterable<Customer> findAllCustomers();
	public Customer findCustomerByCustomerId(String customerId);
	public void deleteCustomerByCustomerId(String customerId);
	public Customer updateByCustomerId(String customerId , int isloggedIn );
		
	
}
