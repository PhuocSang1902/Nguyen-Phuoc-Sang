package com.case_study.service.customer.impl;

import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import com.case_study.repository.customer.ICustomerRepository;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
import com.case_study.viewDto.CustomerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;
    ICustomerTypeService customerTypeService;

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean removeById(Integer id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<CustomerView> showList(String name, String email, int customerTypeId, Pageable pageable) {

        if (customerTypeId == -1 || customerTypeService.findById(customerTypeId).isPresent()) {
            return customerRepository.findByNameContainingAndEmailContaining(name, email, pageable);
        }
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType(name, email, customerTypeService.findById(customerTypeId).get(), pageable);
    }
}
