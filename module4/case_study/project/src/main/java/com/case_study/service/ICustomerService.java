package com.case_study.service;

import com.case_study.model.customer.Customer;

public interface ICustomerService extends IGenericService<Customer>{
    void removeById(Integer id);
}
