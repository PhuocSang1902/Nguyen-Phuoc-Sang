package com.backend.repository;

import com.backend.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    OrderDetail save(OrderDetail orderDetail);
}
