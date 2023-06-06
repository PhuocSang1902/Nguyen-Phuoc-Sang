package repository.impl.employee;

import model.employee.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private static final String GET_BY_ID = "call get_employee_by_id(?);";
    private static final String GET_LIST = "call get_employee_list();";
    private static final String DELETE = "CALL delete_employee_by_id(?);";
    private static final String SEARCH = "call search_employee(?);";
    private static final String ADD = "CALL add_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_BY_ID = "CALL edit_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String employeeId = String.valueOf(id);
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                String salary = resultSet.getString("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positionId = resultSet.getString("position_id");
                String educationDegreeId = resultSet.getString("education_degree_id");
                String divisionId = resultSet.getString("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationName = resultSet.getString("education_name");
                String divisionName = resultSet.getString("division_name");

                employee = new Employee(employeeId, name, birthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId,divisionId,username,positionName,educationName,divisionName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getList() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_LIST);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String employeeId = resultSet.getString("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                String salary = resultSet.getString("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positionId = resultSet.getString("position_id");
                String educationDegreeId = resultSet.getString("education_degree_id");
                String divisionId = resultSet.getString("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationName = resultSet.getString("education_name");
                String divisionName = resultSet.getString("division_name");

                employeeList.add(new Employee(employeeId, name, birthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId,divisionId,username,positionName,educationName,divisionName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean remove(String id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE);
            callableStatement.setInt(1, Integer.parseInt(id));
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> search(String search) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String employeeId = resultSet.getString("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                String salary = resultSet.getString("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positionId = resultSet.getString("position_id");
                String educationDegreeId = resultSet.getString("education_degree_id");
                String divisionId = resultSet.getString("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationName = resultSet.getString("education_name");
                String divisionName = resultSet.getString("division_name");

                employeeList.add(new Employee(employeeId, name, birthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId,divisionId,username,positionName,educationName,divisionName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean add(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD);
            callableStatement.setString(1, employee.getName());
            callableStatement.setString(2, employee.getBirthday());
            callableStatement.setString(3, employee.getIdCard());
            callableStatement.setString(4, employee.getSalary());
            callableStatement.setString(5, employee.getPhoneNumber());
            callableStatement.setString(6, employee.getEmail());
            callableStatement.setString(7, employee.getAddress());
            callableStatement.setString(8, employee.getPositionId());
            callableStatement.setString(9, employee.getEducationDegreeId());
            callableStatement.setString(10, employee.getDivisionId());

            return callableStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(int id, Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_BY_ID);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, employee.getName());
            callableStatement.setString(3, employee.getBirthday());
            callableStatement.setString(4, employee.getIdCard());
            callableStatement.setString(5, employee.getSalary());
            callableStatement.setString(6, employee.getPhoneNumber());
            callableStatement.setString(7, employee.getEmail());
            callableStatement.setString(8, employee.getAddress());
            callableStatement.setString(9, employee.getPositionId());
            callableStatement.setString(10, employee.getEducationDegreeId());
            callableStatement.setString(11, employee.getDivisionId());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}
