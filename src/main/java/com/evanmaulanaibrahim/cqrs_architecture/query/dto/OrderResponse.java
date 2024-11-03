package com.evanmaulanaibrahim.cqrs_architecture.query.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private String customerName;
    private String status;
    private List<OrderItemResponse> items;

    @Data
    public static class OrderItemResponse {
        private String productName;
        private int quantity;
        private double price;
    }
}
