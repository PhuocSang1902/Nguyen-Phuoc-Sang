package practice.service;

import org.springframework.stereotype.Service;
import practice.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    static {
        employeeList.add(new Employee("1", "Nguyen Van A", "123"));
        employeeList.add(new Employee("2", "Nguyen Van B", "124"));
        employeeList.add(new Employee("3", "Nguyen Van C", "125"));
        employeeList.add(new Employee("4", "Nguyen Van D", "126"));
        employeeList.add(new Employee("5", "Nguyen Van E", "127"));
        employeeList.add(new Employee("6", "Nguyen Van F", "128"));
    }
    public List<Employee> getList() {
        return employeeList;
    }

    public boolean add(Employee employee) {
        return employeeList.add(employee);
    }
}
