package com.backend.dto.order;

public interface OrderList {
    Integer getId();

    boolean getPaymentStatus();

    String getDeliveryAddress();

    String getDeliveryPhone();

    double getOrderValue();

    String getOrderDate();

    boolean getStatus();
}
