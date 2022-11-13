package repository.impl.employee;

import model.customer.Customer;
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
}
