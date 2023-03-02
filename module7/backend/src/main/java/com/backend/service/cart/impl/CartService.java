package com.backend.service.cart.impl;

import com.backend.entity.cart.Cart;
import com.backend.repository.ICartRepository;
import com.backend.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAllByIdAccount(Long id) {
        return cartRepository.findCartByCustomerAccountId(id);
    }
}
