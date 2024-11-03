package com.evanmaulanaibrahim.cqrs_architecture.query.service;

import com.evanmaulanaibrahim.cqrs_architecture.command.model.Order;
import com.evanmaulanaibrahim.cqrs_architecture.query.dto.OrderResponse;
import com.evanmaulanaibrahim.cqrs_architecture.query.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderQueryService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToOrderResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(this::mapToOrderResponse)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    private OrderResponse mapToOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setCustomerName(order.getCustomerName());
        response.setStatus(order.getStatus());
        response.setItems(order.getItems().stream().map(item -> {
            OrderResponse.OrderItemResponse itemResponse = new OrderResponse.OrderItemResponse();
            itemResponse.setProductName(item.getProductName());
            itemResponse.setQuantity(item.getQuantity());
            itemResponse.setPrice(item.getPrice());
            return itemResponse;
        }).collect(Collectors.toList()));
        return response;
    }
}
