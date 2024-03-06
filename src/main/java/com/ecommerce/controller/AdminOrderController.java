package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Order;
import com.ecommerce.exception.OrderException;
import com.ecommerce.response.ApiResponse;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();

		return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{orderId}/confirmed")
	public ResponseEntity<Order> confirmedOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt)
			throws OrderException {
		Order order = orderService.confirmedOrder(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{orderId}/ship")
	public ResponseEntity<Order> shippedOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt)
			throws OrderException {
		Order order = orderService.shippedOrder(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{orderId}/deliver")
	public ResponseEntity<Order> deliveredOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt)
			throws OrderException {
		Order order = orderService.deliveredOrder(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{orderId}/cancel")
	public ResponseEntity<Order> cancledOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt)
			throws OrderException {
		Order order = orderService.cancledOrder(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{orderId}/delete")
	public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Long orderId,
			@RequestHeader("Authorization") String jwt) throws OrderException {
		orderService.deleteOrder(orderId);
		ApiResponse res = new ApiResponse("Order Deleted Successfully", true);
		System.out.println("delete method working....");
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}

}
