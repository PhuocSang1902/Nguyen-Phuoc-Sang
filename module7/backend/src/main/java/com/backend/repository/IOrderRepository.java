package com.backend.repository;

import com.backend.entity.order.OrderDetail;
import com.backend.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IOrderRepository extends JpaRepository<Orders, Integer> {
}
