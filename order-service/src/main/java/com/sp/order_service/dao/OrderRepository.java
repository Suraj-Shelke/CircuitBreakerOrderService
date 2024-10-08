package com.sp.order_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.order_service.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
