package com.backend.dto.order;

public interface OrderDetailList {
    Integer getId();

    Integer getIdProduct();

    Long getCode();

    String getName();

    int getCost();

    String getImage();

    Integer getNumberOfProduct();

    Integer getTotalCost();
}
