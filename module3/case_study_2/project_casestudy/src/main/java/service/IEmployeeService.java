package service;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee findById(int id);

    List<Employee> getList();

    boolean remove(String id);

    List<Employee> search(String search);
}
