package com.walmart.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.orderservice.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    
}
