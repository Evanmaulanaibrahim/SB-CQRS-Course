package com.evanmaulanaibrahim.cqrs_architecture.command.controller;

import com.evanmaulanaibrahim.cqrs_architecture.command.dto.CreateOrderRequest;
import com.evanmaulanaibrahim.cqrs_architecture.command.model.Order;
import com.evanmaulanaibrahim.cqrs_architecture.command.service.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commands/orders")
public class OrderCommandController {

    @Autowired
    private OrderCommandService orderCommandService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(orderCommandService.createOrder(request));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(orderCommandService.updateOrderStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderCommandService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
