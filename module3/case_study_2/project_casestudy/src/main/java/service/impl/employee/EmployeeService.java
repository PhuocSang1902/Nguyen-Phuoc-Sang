package service.impl.employee;

import model.employee.Employee;
import repository.IEmployeeRepository;
import repository.impl.employee.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getList() {
        return employeeRepository.getList();
    }

    @Override
    public boolean remove(String id) {
        return employeeRepository.remove(id);
    }

    @Override
    public List<Employee> search(String search) {
        return employeeRepository.search(search);
    }
}
