package com.backend.service.cart;

import com.backend.entity.cart.Cart;

import java.util.List;

public interface ICartService {
    void save(Cart cart);

    List<Cart> findAllByIdAccount(Long id);
}
