package com.onlinesweetshopapi.serviceimpl;

import com.onlinesweetshopapi.domain.Customer;
import com.onlinesweetshopapi.domain.Event;
import com.onlinesweetshopapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

import com.onlinesweetshopapi.repository.CustomerRepository;
import com.onlinesweetshopapi.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository EventRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Event saveOrUpdate(Event event) throws EventException {
		// TODO Auto-generated method stub
		String customerIdentifier = event.getCustomerIdentifier(); 
		Customer customer = customerRepository.findByCustomerId(customerIdentifier);
		System.out.println(EventRepository);
		event.setCustomer(customer);
		return EventRepository.save(event);
		
		
	}
}

