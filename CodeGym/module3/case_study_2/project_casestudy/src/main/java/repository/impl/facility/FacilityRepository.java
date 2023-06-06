package repository.impl.facility;

import model.Facility.Facility;
import repository.BaseRepository;
import repository.IFacilityRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String SELECT_ALL = "CALL select_facility();";
    private static final String ADD = "CALL add_facility(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String GET_BY_ID = "CALL get_facility_by_id(?);";
    private static final String UPDATE_BY_ID = "CALL edit_facility(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SEARCH = "CALL search_facility(?);";
    private static final String DELETE = "CALL delete_facility_by_id(?);";

    @Override
    public List<Facility> getList() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement ps = connection.prepareCall(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String area = resultSet.getString("area");
                String cost = resultSet.getString("cost");
                String maxPeople = resultSet.getString("max_people");
                String rentTypeId = resultSet.getString("rent_type_id");
                String facilityTypeId = resultSet.getString("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                String poolArea = resultSet.getString("pool_area");
                String numberOfFloor = resultSet.getString("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                String rentTypeName = resultSet.getString("rent_type_name");
                String facilityTypeName = resultSet.getString("facility_type_name");
                facilityList.add(new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, numberOfFloor, facilityFree, rentTypeName, facilityTypeName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public boolean add(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD);
            callableStatement.setString(1, facility.getName());
            callableStatement.setInt(2, Integer.parseInt(facility.getArea()));
            callableStatement.setDouble(3, Double.parseDouble(facility.getCost()));
            callableStatement.setInt(4, Integer.parseInt(facility.getMaxPeople()));
            callableStatement.setInt(5, Integer.parseInt(facility.getRentTypeId()));
            callableStatement.setInt(6, Integer.parseInt(facility.getFacilityTypeId()));
            callableStatement.setString(7, facility.getStandardRoom());
            callableStatement.setString(8, facility.getDescription());
            callableStatement.setString(9, facility.getPoolArea());
            callableStatement.setString(10, facility.getNumberOfFloor());
            callableStatement.setString(11, facility.getFacilityFree());

            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Facility findById(int id) {
        Facility facility = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String facilityId = String.valueOf(id);
                String name = resultSet.getString("name");
                String area = resultSet.getString("area");
                String cost = resultSet.getString("cost");
                String maxPeople = resultSet.getString("max_people");
                String rentTypeId = resultSet.getString("rent_type_id");
                String facilityTypeId = resultSet.getString("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                String poolArea = resultSet.getString("pool_area");
                String numberOfFloor = resultSet.getString("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                String rentTypeName = resultSet.getString("rent_type_name");
                String facilityTypeName = resultSet.getString("facility_type_name");
                facility = new Facility(facilityId, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, numberOfFloor, facilityFree, rentTypeName, facilityTypeName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facility;
    }

    @Override
    public boolean edit(int id, Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_BY_ID);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, facility.getName());
            callableStatement.setString(3, facility.getArea());
            callableStatement.setString(4, facility.getCost());
            callableStatement.setString(5, facility.getMaxPeople());
            callableStatement.setString(6, facility.getRentTypeId());
            callableStatement.setString(7, facility.getFacilityTypeId());
            callableStatement.setString(8, facility.getStandardRoom());
            callableStatement.setString(9, facility.getDescription());
            callableStatement.setString(10, facility.getPoolArea());
            callableStatement.setString(11, facility.getNumberOfFloor());
            callableStatement.setString(12, facility.getFacilityFree());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Facility> search(String search) {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String area = resultSet.getString("area");
                String cost = resultSet.getString("cost");
                String maxPeople = resultSet.getString("max_people");
                String rentTypeId = resultSet.getString("rent_type_id");
                String facilityTypeId = resultSet.getString("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                String poolArea = resultSet.getString("pool_area");
                String numberOfFloor = resultSet.getString("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                String rentTypeName = resultSet.getString("rent_type_name");
                String facilityTypeName = resultSet.getString("facility_type_name");
                facilityList.add(new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, description, poolArea, numberOfFloor, facilityFree, rentTypeName, facilityTypeName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
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
}
