package com.backend.service.order;

import com.backend.dto.order.OrderDetailList;
import com.backend.entity.order.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetailList> getListByOrder(int id);
}
