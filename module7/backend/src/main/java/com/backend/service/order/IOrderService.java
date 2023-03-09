package com.backend.service.order;

import com.backend.entity.order.Orders;

import java.util.Optional;

public interface IOrderService {
    Orders save(Orders orders);

    Optional<Orders> findById(int id);
}
