package com.ordermangement.services;

import java.util.UUID;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.stereotype.Service;

import com.ordermangement.dto.OrderLineItemsDto;
import com.ordermangement.dto.OrderRequest;
import com.ordermangement.model.Order;
import com.ordermangement.model.OrderLineItems;
import com.ordermangement.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Orderservice {

	
	private final OrderRepository orderRepository ;
	
	
	
	
	
	public void placeorder (OrderRequest orderrequest)
	{
		Order order = new Order();
		
		order.setOrderNumber(UUID.randomUUID().toString());
		
		orderrequest.getOrderLineItemsDtoList().stream().map(this::mapToDto).toList();
		
		orderRepository.save(order);
		
	}
	
   private OrderLineItems mapToDto(OrderLineItemsDto orderlineitemsdto)
   {
           OrderLineItems orderLineItems = new OrderLineItems();
           orderLineItems.setPrice(orderLineItems.getPrice());
           orderLineItems.setQuality(orderLineItems.getQuality());
           orderLineItems.setSkuCode(orderLineItems.getSkuCode());
           
           return orderLineItems;

	   
   }
	
	
	
}
