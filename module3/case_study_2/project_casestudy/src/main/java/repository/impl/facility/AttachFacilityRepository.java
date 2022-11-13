package repository.impl.facility;

import model.Facility.AttachFacility;
import model.Facility.Facility;
import model.Facility.FacilityType;
import model.contract.Contract;
import model.customer.Customer;
import model.employee.Employee;
import repository.BaseRepository;
import repository.IAttachFacilityRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttachFacilityRepository implements IAttachFacilityRepository {
    private static final String GET_BY_ID = "CALL get_attach_facility_by_id(?);";
    private static final String SELECT_ALL = "SELECT * FROM attach_facility;";

    @Override
    public AttachFacility findById(int id) {
        AttachFacility attachFacility = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String attachFacilityId = String.valueOf(id);
                String name = resultSet.getString("name");
                String cost = resultSet.getString("cost");
                String unit = resultSet.getString("unit");
                String status = resultSet.getString("status");
                attachFacility = new AttachFacility(attachFacilityId, name, cost, unit, status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachFacility;
    }

    @Override
    public List<AttachFacility> getList() {
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String cost = resultSet.getString("cost");
                String unit = resultSet.getString("unit");
                String status = resultSet.getString("status");
                attachFacilityList.add(new AttachFacility(id, name, cost, unit, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachFacilityList;
    }
}
