package com.backend.service.customer.impl;

import com.backend.entity.customer.Customer;
import com.backend.repository.ICustomerRepository;
import com.backend.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
