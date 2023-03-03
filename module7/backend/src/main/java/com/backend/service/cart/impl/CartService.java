package com.backend.service.cart.impl;

import com.backend.dto.cart.CartList;
import com.backend.dto.cart.CartTotal;
import com.backend.entity.cart.Cart;
import com.backend.entity.customer.Customer;
import com.backend.entity.product.Product;
import com.backend.repository.ICartRepository;
import com.backend.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<CartList> findAllByIdAccount(Long id) {
        return cartRepository.findCartByCustomerAccountId(id);
    }

    @Override
    public Optional<Cart> findById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void removeById(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Optional<Cart> findByProductAndCustomer(Product product, Customer customer) {
        return cartRepository.findCartByCustomer_IdAndProduct_Id(customer.getId(), product.getId());
    }

    @Override
    public Optional<CartTotal> getTotal(Long id) {
        return cartRepository.totalCartByIdAccount(id);
    }
}
