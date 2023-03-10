package com.backend.service.order;

import com.backend.dto.order.OrderList;
import com.backend.entity.order.Orders;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Orders save(Orders orders);

    Optional<Orders> findById(int id);

    List<OrderList> getListByIdCustomer(int id);

    Optional<Orders> findByIdPaymentStatus(int id);
}
