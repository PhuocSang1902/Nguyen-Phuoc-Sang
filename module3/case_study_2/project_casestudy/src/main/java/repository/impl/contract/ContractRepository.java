package repository.impl.contract;

import model.Facility.Facility;
import model.contract.Contract;
import model.customer.Customer;
import model.employee.Employee;
import repository.BaseRepository;
import repository.IContractRepository;
import service.ICustomerService;
import service.IEmployeeService;
import service.IFacilityService;
import service.impl.customer.CustomerService;
import service.impl.employee.EmployeeService;
import service.impl.facility.FacilityService;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractRepository implements IContractRepository {
    private IEmployeeService employeeService = new EmployeeService();
    private ICustomerService customerService = new CustomerService();
    private IFacilityService facilityService = new FacilityService();
    private static final String GET_BY_ID = "CALL get_contract_by_id(?);";
    private static final String SELECT_CONTRACT = "CALL select_contract();";
    private static final String SEARCH = "CALL select_contract();";
    private static final String SELECT_CONTRACT_WITH_VALUE = "CALL select_contract_with_value();";
    private static final String ADD = "CALL add_contract(?,?,?,?,?,?);";

    @Override
    public Contract findById(int id) {
        Contract contract = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String contractId = String.valueOf(id);
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String deposit = resultSet.getString("deposit");
                String employeeId = resultSet.getString("employee_id");
                String customerId = resultSet.getString("customer_id");
                String facilityId = resultSet.getString("facility_id");
                Employee employee = employeeService.findById(Integer.parseInt(employeeId));
                Customer customer = customerService.findById(Integer.parseInt(customerId));
                Facility facility = facilityService.findById(Integer.parseInt(facilityId));
                contract = new Contract(contractId, startDate, endDate, deposit, employee, customer, facility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contract;
    }

    @Override
    public List<Contract> getList() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_CONTRACT);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String deposit = resultSet.getString("deposit");
                String employeeId = resultSet.getString("employee_id");
                String customerId = resultSet.getString("customer_id");
                String facilityId = resultSet.getString("facility_id");
                Employee employee = employeeService.findById(Integer.parseInt(employeeId));
                Customer customer = customerService.findById(Integer.parseInt(customerId));
                Facility facility = facilityService.findById(Integer.parseInt(facilityId));
                contractList.add(new Contract(id, startDate, endDate, deposit, employee, customer, facility));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public Map<Contract, String> getListWithValue() {
        Map<Contract, String> contractMap = new HashMap<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_CONTRACT_WITH_VALUE);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String deposit = resultSet.getString("deposit");
                String employeeId = resultSet.getString("employee_id");
                String customerId = resultSet.getString("customer_id");
                String facilityId = resultSet.getString("facility_id");
                Employee employee = employeeService.findById(Integer.parseInt(employeeId));
                Customer customer = customerService.findById(Integer.parseInt(customerId));
                Facility facility = facilityService.findById(Integer.parseInt(facilityId));
                String totalValue = resultSet.getString("total_value");
                contractMap.put(new Contract(id, startDate, endDate, deposit, employee, customer, facility), totalValue);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractMap;
    }

    @Override
    public List<Contract> search(String search) {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String deposit = resultSet.getString("deposit");
                String employeeId = resultSet.getString("employee_id");
                String customerId = resultSet.getString("customer_id");
                String facilityId = resultSet.getString("facility_id");
                Employee employee = employeeService.findById(Integer.parseInt(employeeId));
                Customer customer = customerService.findById(Integer.parseInt(customerId));
                Facility facility = facilityService.findById(Integer.parseInt(facilityId));
                contractList.add(new Contract(id, startDate, endDate, deposit, employee, customer, facility));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean add(Contract contract) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD);
            callableStatement.setString(1, contract.getStartDate());
            callableStatement.setString(2, contract.getEndDate());
            callableStatement.setString(3, contract.getDeposit());
            callableStatement.setString(4, contract.getEmployee().getId());
            callableStatement.setString(5, contract.getCustomer().getId());
            callableStatement.setString(6, contract.getFacility().getId());

            return callableStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
