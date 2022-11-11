package repository;

import model.employee.Employee;

public interface IEmployeeRepository {
    Employee findById(int id);
}
