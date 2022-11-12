package service;

import model.employee.Employee;

public interface IEmployeeService {
    Employee findById(int id);
}
