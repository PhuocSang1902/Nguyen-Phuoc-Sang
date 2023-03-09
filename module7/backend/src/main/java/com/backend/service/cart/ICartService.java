package com.backend.service.cart;

import com.backend.dto.cart.CartList;
import com.backend.dto.cart.CartTotal;
import com.backend.entity.cart.Cart;
import com.backend.entity.customer.Customer;
import com.backend.entity.product.Product;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    void save(Cart cart);

    Optional<Cart> findById(int id);

    void removeById(int id);

    Optional<Cart> findByProductAndCustomer(Product product, Customer customer);

    Optional<CartTotal> getTotal(Customer customer);

    List<CartList> findAllByCustomer(Customer customer);

    void deleteById(Integer id);
}
