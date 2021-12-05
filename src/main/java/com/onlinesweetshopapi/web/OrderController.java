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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetshopapi.domain.Order;
import com.onlinesweetshopapi.exception.OrderIdException;
import com.onlinesweetshopapi.service.OrderService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;



@RestController
@RequestMapping("/api/orders")
public class OrderController {
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping
	public ResponseEntity<?> createOrder(@Valid @RequestBody Order order, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Order createdOrder= orderService.saveOrUpdate(order);
		return new ResponseEntity<Order>(createdOrder, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId){
		Order order= orderService.findOrderByOrderId(orderId);
		logger.info("--ORDER--"+order);
		if(order==null) {
			throw new OrderIdException("Order Id: "+orderId.toUpperCase()+" does not exist");
		}
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Order> getAllOrders(){
		return orderService.findAllOrders();
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable String orderId){
		orderService.deleteOrderByOrderId(orderId);
		return new ResponseEntity<String>("Order With id : "+orderId.toUpperCase()+" is deleted successfully",HttpStatus.OK);
	}
}
