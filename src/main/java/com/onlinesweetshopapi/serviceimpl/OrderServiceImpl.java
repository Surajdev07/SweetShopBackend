package com.onlinesweetshopapi.serviceimpl;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetshopapi.domain.Customer;
import com.onlinesweetshopapi.domain.Feedback;
import com.onlinesweetshopapi.domain.Order;
import com.onlinesweetshopapi.domain.Sweet;
import com.onlinesweetshopapi.exception.OrderIdException;
import com.onlinesweetshopapi.repository.CustomerRepository;
import com.onlinesweetshopapi.repository.OrderRepository;
import com.onlinesweetshopapi.repository.SweetRepository;
import com.onlinesweetshopapi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private SweetRepository sweetRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	public Order saveOrUpdate(Order order) throws OrderIdException{
		// TODO Auto-generated method stub
		
		try {
		if(order.getId() == null) {
			
			String sweetIdentifier = order.getSweetIdentifier();
			Sweet sweet = sweetRepository.findBySweetIdentifier(sweetIdentifier);
			String customerIdentifier = order.getCustomerIdentifier();
			Customer customer = customerRepository.findByCustomerId(customerIdentifier);
			Feedback feedback = new Feedback();
			List<Sweet> sweets = order.getSweets();
			sweets.add(sweet);
			double orderPrice = sweet.getNetPrice();
			order.setSweets(sweets);
			order.setFeedback(feedback);
			order.setOrderPrice(orderPrice);
			order.setOrderId(order.getOrderId().toUpperCase());
			order.setCustomer(customer);
		}
		
		return orderRepository.save(order);
		}
		catch(Exception e)
		{
			throw new OrderIdException("Order Id" + order.getOrderId()+ " is already available");
		}
		
	}

	@Override
	public Iterable<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order findOrderByOrderId(String orderId) {
		Order order = orderRepository.findByOrderId(orderId);
		return order;

	}
	
	@Override
	public void deleteOrderByOrderId(String orderId) {
		Order order= orderRepository.findByOrderId(orderId.toUpperCase());
		if(order==null) {
			throw new OrderIdException("Can not delete order with order id "+orderId.toUpperCase()+". This id does not exist");
		}
		
		orderRepository.delete(order);
		
	}
	



	

}
