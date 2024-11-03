package com.evanmaulanaibrahim.cqrs_architecture.command.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private String customerName;
    private List<OrderItemRequest> items;

    @Data
    public static class OrderItemRequest {
        private String productName;
        private int quantity;
        private double price;
    }
}
