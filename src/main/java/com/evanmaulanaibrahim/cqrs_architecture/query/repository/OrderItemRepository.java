package com.evanmaulanaibrahim.cqrs_architecture.query.repository;

import com.evanmaulanaibrahim.cqrs_architecture.command.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
