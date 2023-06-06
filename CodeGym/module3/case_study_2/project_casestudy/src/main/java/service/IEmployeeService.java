package service;

import model.employee.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    Employee findById(int id);

    List<Employee> getList();

    boolean remove(String id);

    List<Employee> search(String search);

    Map<String, String> add(Employee employee);

    boolean edit(int id, Employee employee);
}
