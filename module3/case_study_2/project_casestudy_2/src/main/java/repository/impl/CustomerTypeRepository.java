package repository.impl;

import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static final String SELECT_ALL = "SELECT * FROM customer_type;";

    @Override
    public List<CustomerType> getList() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                customerTypeList.add(new CustomerType(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
