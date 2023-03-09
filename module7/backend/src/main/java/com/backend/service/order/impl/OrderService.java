package com.backend.service.order.impl;

import com.backend.entity.order.Orders;
import com.backend.repository.IOrderRepository;
import com.backend.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Optional<Orders> findById(int id) {
        return orderRepository.findById(id);
    }
}
