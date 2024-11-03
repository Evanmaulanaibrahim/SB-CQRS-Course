package com.evanmaulanaibrahim.cqrs_architecture.query.repository;

import com.evanmaulanaibrahim.cqrs_architecture.command.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
