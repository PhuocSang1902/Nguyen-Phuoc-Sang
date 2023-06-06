package com.customermanegement.practice1.service;

import com.customermanegement.practice1.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Integer id);
    void save(Customer customer);
    void remove(Integer id);
}
