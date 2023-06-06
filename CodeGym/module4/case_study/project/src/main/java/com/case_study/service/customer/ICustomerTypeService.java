package com.case_study.service.customer;

import com.case_study.model.customer.CustomerType;
import com.case_study.service.IGenericService;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService{
    List<CustomerType> findAll();

    Optional<CustomerType> findById(int customerTypeId);
}
