package com.backend.service.customer;

import com.backend.entity.customer.Customer;

import java.util.Optional;

public interface ICustomerService {
    void save(Customer customer);

    Optional<Customer> findByIdAccount(Long id);
}
