package com.onlinesweetshopapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Customer findByCustomerId(String customerId);
	
}
