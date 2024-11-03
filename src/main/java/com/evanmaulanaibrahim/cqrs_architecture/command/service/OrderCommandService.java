package com.evanmaulanaibrahim.cqrs_architecture.command.service;

import com.evanmaulanaibrahim.cqrs_architecture.command.dto.CreateOrderRequest;
import com.evanmaulanaibrahim.cqrs_architecture.command.model.Order;
import com.evanmaulanaibrahim.cqrs_architecture.command.model.OrderItem;
import com.evanmaulanaibrahim.cqrs_architecture.query.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderCommandService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setStatus("PENDING");

        List<OrderItem> items = request.getItems().stream()
                .map(itemRequest -> {
                    OrderItem item = new OrderItem();
                    item.setProductName(itemRequest.getProductName());
                    item.setQuantity(itemRequest.getQuantity());
                    item.setPrice(itemRequest.getPrice());
                    return item;
                }).collect(Collectors.toList());

        order.setItems(items);
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new RuntimeException("Order not found")
                );
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

}
