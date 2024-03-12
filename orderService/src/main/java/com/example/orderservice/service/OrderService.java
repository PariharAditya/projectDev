package com.example.orderservice.service;

import com.example.orderservice.dto.OrderLineItemsDTO;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.OrderData;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        // Place OrderData logic
        OrderData ordr = new OrderData();
        ordr.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsD()
                .stream()
                .map(this::mapToOrderLineItems)
                .toList();
        ordr.setOrderLineItemsList(orderLineItems);

        // Save order to database
        orderRepository.save(ordr);
    }

    private OrderLineItems mapToOrderLineItems(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        return orderLineItems;
    }
}
