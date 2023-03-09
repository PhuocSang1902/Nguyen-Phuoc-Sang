package com.backend.service.order.impl;

import com.backend.entity.order.OrderDetail;
import com.backend.repository.IOrderDetailRepository;
import com.backend.repository.IOrderRepository;
import com.backend.service.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
}
