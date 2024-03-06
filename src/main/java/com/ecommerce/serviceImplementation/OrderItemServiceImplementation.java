package com.ecommerce.serviceImplementation;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.OrderItem;
import com.ecommerce.repository.OrderItemRepository;
import com.ecommerce.service.OrderItemService;

@Service
public class OrderItemServiceImplementation implements OrderItemService {

	private OrderItemRepository orderItemRepository;
	public OrderItemServiceImplementation(OrderItemRepository orderItemRepository) {
		this.orderItemRepository=orderItemRepository;
	}
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}

}
