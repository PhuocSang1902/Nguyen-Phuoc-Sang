package com.case_study.service.Impl;

import com.case_study.model.customer.Customer;
import com.case_study.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {


    @Override
    public Page<Customer> findAllAndByName(String search, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void edit(Integer id) {

    }
}
