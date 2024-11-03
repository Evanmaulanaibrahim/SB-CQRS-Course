package com.evanmaulanaibrahim.cqrs_architecture.query.controller;

import com.evanmaulanaibrahim.cqrs_architecture.query.dto.OrderResponse;
import com.evanmaulanaibrahim.cqrs_architecture.query.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/queries/orders")
public class OrderQueryController {
    @Autowired
    private OrderQueryService orderQueryService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderQueryService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderQueryService.getOrderById(id));
    }
}
