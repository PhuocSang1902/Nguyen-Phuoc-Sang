package com.case_study.service.Impl;

import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }
}
