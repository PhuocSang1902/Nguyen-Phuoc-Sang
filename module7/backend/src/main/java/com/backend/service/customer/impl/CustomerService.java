package com.backend.service.customer.impl;

import com.backend.entity.customer.Customer;
import com.backend.repository.ICustomerRepository;
import com.backend.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByIdAccount(Long id) {
        return customerRepository.findByAccount_IdAccount(id);
    }

    @Override
    public Optional<Customer> findById(int idCustomer) {
        return customerRepository.findById(idCustomer);
    }
}
