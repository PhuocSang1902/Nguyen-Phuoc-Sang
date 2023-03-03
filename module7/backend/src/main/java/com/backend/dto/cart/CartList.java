package com.backend.dto.cart;

public interface CartList {
    Integer getId();

    Integer getIdProduct();

    Long getCode();

    String getName();

    int getCost();

    String getImage();

    Integer getIdCustomer();

    Integer getNumberOfProduct();

    Integer getTotalCost();
}
