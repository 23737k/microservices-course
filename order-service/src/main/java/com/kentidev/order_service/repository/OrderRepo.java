package com.kentidev.order_service.repository;

import com.kentidev.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
