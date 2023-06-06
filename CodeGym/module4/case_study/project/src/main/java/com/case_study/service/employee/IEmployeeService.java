package com.case_study.service.employee;

import com.case_study.model.employee.Employee;
import com.case_study.service.IGenericService;

import java.util.List;

public interface IEmployeeService extends IGenericService<Employee> {
    List<Employee> findAll();
}
