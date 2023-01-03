package com.case_study.service.customer.impl;

import com.case_study.dtoView.CustomerUseFacilityView;
import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import com.case_study.repository.customer.ICustomerRepository;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
import com.case_study.dtoView.CustomerView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {


    private ICustomerRepository customerRepository;
    private ICustomerTypeService customerTypeService;

    public CustomerService(ICustomerRepository customerRepository,ICustomerTypeService customerTypeService) {
        this.customerRepository = customerRepository;
        this.customerTypeService = customerTypeService;
    }

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
        Optional<CustomerType> customerType = customerTypeService.findById(customerTypeId);
        if (customerTypeId == -1 || !customerType.isPresent()) {
            return customerRepository.findByNameContainingAndEmailContaining(name, email, pageable);
        }
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType(name, email, customerType.get(), pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<CustomerUseFacilityView> showListUseFacility(String customerName, String email, int customerTypeId, Pageable pageable) {
        Optional<CustomerType> customerType = customerTypeService.findById(customerTypeId);
        if (customerTypeId == -1 || !customerType.isPresent()) {
            return customerRepository.showListUseFacilityByNameAndEmail(customerName, email, pageable);
        }
        return customerRepository.showListUseFacilityByNameAndEmailAndCustomerType(customerName, email, customerTypeId, pageable);
    }

    @Override
    public List<Customer> showListSelect() {
        return customerRepository.findAll();
    }
}
