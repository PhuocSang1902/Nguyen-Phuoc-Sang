package com.case_study.service.employee.impl;

import com.case_study.model.employee.Employee;
import com.case_study.service.employee.IEmployeeService;
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
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }
}
