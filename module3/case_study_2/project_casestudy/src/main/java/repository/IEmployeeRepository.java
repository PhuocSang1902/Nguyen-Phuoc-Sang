package repository;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    Employee findById(int id);

    List<Employee> getList();
}
