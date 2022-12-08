package com.case_study.service.customer.impl;

import com.case_study.model.customer.Customer;
import com.case_study.service.customer.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Override
    public Optional<Customer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(Customer customer) {
        return false;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }
}
