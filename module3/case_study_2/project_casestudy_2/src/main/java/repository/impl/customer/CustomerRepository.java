package repository.impl.customer;

import model.customer.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL = "CALL select_customer();";
    private static final String GET_BY_ID = "CALL get_customer_by_id(?);";
    private static final String DELETE = "CALL delete_by_id(?);";
    private static final String UPDATE_BY_ID = "CALL edit_customer(?,?,?,?,?,?,?,?,?);";
    private static final String ADD = "CALL add_customer(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SEARCH = "call search_customer(?);";
    private static final String SELECT_USE_FACILITY = "call search_customer(?);";

    @Override
    public List<Customer> getList() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement ps = connection.prepareCall(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String customerType = resultSet.getString("customer_type_id");
                String nameCustomerType = resultSet.getString("type_customer_name");
                String birthday = resultSet.getString("date_of_birth");
                String gender = resultSet.getString("gender");
                String genderName;
                switch (gender) {
                    case "1":
                        genderName = "Nam";
                        break;
                    case "0":
                        genderName = "Nữ";
                        break;
                    default:
                        genderName = "Khác";
                        break;
                }
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customerList.add(new Customer(id, name, customerType, nameCustomerType, birthday, genderName, idCard, phoneNumber, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
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
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String customerId = String.valueOf(id);
                String name = resultSet.getString("name");
                String customerType = resultSet.getString("customer_type_id");
                String nameCustomerType = resultSet.getString("type_customer_name");
                String birthday = resultSet.getString("date_of_birth");
                String gender = resultSet.getString("gender");
                String genderName;
                switch (gender) {
                    case "1":
                        genderName = "Nam";
                        break;
                    case "0":
                        genderName = "Nữ";
                        break;
                    default:
                        genderName = "Khác";
                        break;
                }
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer = new Customer(customerId, name, customerType, nameCustomerType, birthday, genderName, idCard, phoneNumber, email, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean edit(int id, Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_BY_ID);
            callableStatement.setInt(1, id);
            callableStatement.setInt(2, Integer.parseInt(customer.getCustomerType()));
            callableStatement.setString(3, customer.getName());
            callableStatement.setString(4, customer.getBirthday());
            int gender;
            switch (customer.getGender()) {
                case "Nam":
                    gender = 1;
                    break;
                case "Nữ":
                    gender = 0;
                    break;
                default:
                    gender = 2;
                    break;
            }
            callableStatement.setInt(5, gender);
            callableStatement.setString(6, customer.getIdCard());
            callableStatement.setString(7, customer.getPhoneNumber());
            callableStatement.setString(8, customer.getEmail());
            callableStatement.setString(9, customer.getAddress());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean add(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD);
            callableStatement.setInt(1, Integer.parseInt(customer.getCustomerType()));
            callableStatement.setString(2, customer.getName());
            callableStatement.setString(3, customer.getBirthday());
            int gender;
            switch (customer.getGender()) {
                case "Nam":
                    gender = 1;
                    break;
                default:
                    gender = 0;
                    break;
            }
            callableStatement.setInt(4, gender);
            callableStatement.setString(5, customer.getIdCard());
            callableStatement.setString(6, customer.getPhoneNumber());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getAddress());

            return callableStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> search(String search) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String customerType = resultSet.getString("customer_type_id");
                String nameCustomerType = resultSet.getString("type_customer_name");
                String birthday = resultSet.getString("date_of_birth");
                String gender = resultSet.getString("gender");
                String genderName;
                switch (gender) {
                    case "1":
                        genderName = "Nam";
                        break;
                    case "0":
                        genderName = "Nữ";
                        break;
                    default:
                        genderName = "Khác";
                        break;
                }
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customerList.add(new Customer(id, name, customerType, nameCustomerType, birthday, genderName, idCard, phoneNumber, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> getListUseFacility() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement ps = connection.prepareCall(SELECT_USE_FACILITY);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String customerType = resultSet.getString("customer_type_id");
                String nameCustomerType = resultSet.getString("type_customer_name");
                String birthday = resultSet.getString("date_of_birth");
                String gender = resultSet.getString("gender");
                String genderName;
                switch (gender) {
                    case "1":
                        genderName = "Nam";
                        break;
                    case "0":
                        genderName = "Nữ";
                        break;
                    default:
                        genderName = "Khác";
                        break;
                }
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customerList.add(new Customer(id, name, customerType, nameCustomerType, birthday, genderName, idCard, phoneNumber, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

}
