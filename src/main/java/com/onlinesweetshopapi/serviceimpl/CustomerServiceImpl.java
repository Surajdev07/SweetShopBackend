package com.onlinesweetshopapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetshopapi.domain.Customer;
import com.onlinesweetshopapi.exception.CustomerIdException;
import com.onlinesweetshopapi.repository.CustomerRepository;
import com.onlinesweetshopapi.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveOrUpdate(Customer customer) throws CustomerIdException{
		// TODO Auto-generated method stub
		try {
				customer.setCustomerId(customer.getCustomerId().toUpperCase());
				return customerRepository.save(customer);
		}
		catch(Exception e)
		{
				throw new CustomerIdException("Customer Id" + customer.getCustomerId() + "is already available");
				
		}
		}

	@Override
	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerByCustomerId(String customerId) {
		Customer customer= customerRepository.findByCustomerId(customerId.toUpperCase());
		System.out.println("Customer Json response"+customer);
		return customer;
	}
	
	@Override
	public void deleteCustomerByCustomerId(String customerId) {
		Customer customer= customerRepository.findByCustomerId(customerId.toUpperCase());
		if(customer==null) {
			throw new CustomerIdException("Can not delete customer with customer id "+customerId.toUpperCase()+". This id does not exist");
		}
		customerRepository.delete(customer);
	}
	
	@Override
	public Customer updateByCustomerId(String customerId, int isloggedIn) {
	
	Customer customer=	findCustomerByCustomerId(customerId);
	customer.setIsloggedIn(isloggedIn);
		return customerRepository.save(customer);
	}
	



	

}
