package com.example.practice3.service.impl;

import com.example.practice3.model.Customer;
import com.example.practice3.repository.ICustomerRepository;
import com.example.practice3.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName) {
        return customerRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
    }
}
