package com.case_study.service.customer.impl;

import com.case_study.model.customer.CustomerType;
import com.case_study.repository.customer.ICustomerTypeRepository;
import com.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(int customerTypeId) {
        return customerTypeRepository.findById(customerTypeId);
    }
}
