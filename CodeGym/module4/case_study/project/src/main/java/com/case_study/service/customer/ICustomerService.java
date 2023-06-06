package com.case_study.service.customer;

import com.case_study.dtoView.CustomerUseFacilityView;
import com.case_study.model.customer.Customer;
import com.case_study.service.IGenericService;
import com.case_study.dtoView.CustomerView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGenericService<Customer> {
    Page<CustomerView> showList(String name, String email, int customerTypeId, Pageable pageable);

    List<Customer> findAll();

    Page<CustomerUseFacilityView> showListUseFacility(String customerName, String email, int customerTypeId, Pageable pageable);

    List<Customer> showListSelect();
}
