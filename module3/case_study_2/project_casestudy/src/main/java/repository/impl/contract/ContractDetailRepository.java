package repository.impl.contract;

import model.Facility.AttachFacility;
import model.Facility.Facility;
import model.contract.Contract;
import model.contract.ContractDetail;
import model.customer.Customer;
import model.employee.Employee;
import repository.BaseRepository;
import repository.IContractDetailRepository;
import service.IAttachFacilityService;
import service.IContractService;
import service.impl.contract.ContractService;
import service.impl.facility.AttachFacilityService;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    private IContractService contractService = new ContractService();
    private IAttachFacilityService attachFacilityService = new AttachFacilityService();
    private static final String SELECT_CONTRACT_DETAIL = "CALL select_contract_detail();";
    private static final String SELECT_DETAIL_IN_CONTRACT = "CALL select_detail_in_contract(?);";
    private static final String ADD = "CALL add_contract_detail(?,?,?);";
    @Override
    public List<ContractDetail> getList() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_CONTRACT_DETAIL);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String contractId = resultSet.getString("contract_id");
                Contract contract = contractService.findById(Integer.parseInt(contractId));
                String attachFacilityId = resultSet.getString("attach_facility_id");
                AttachFacility attachFacility = attachFacilityService.findById(Integer.parseInt(attachFacilityId));
                String quantity = resultSet.getString("quantity");

                contractDetailList.add(new ContractDetail(id, contract, attachFacility, quantity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetailList;
    }

    @Override
    public List<ContractDetail> getListInContract(int contractId) {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_DETAIL_IN_CONTRACT);
            callableStatement.setInt(1, contractId);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                Contract contract = contractService.findById(contractId);
                String attachFacilityId = resultSet.getString("attach_facility_id");
                AttachFacility attachFacility = attachFacilityService.findById(Integer.parseInt(attachFacilityId));
                String quantity = resultSet.getString("quantity");

                contractDetailList.add(new ContractDetail(id, contract, attachFacility, quantity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetailList;
    }

    @Override
    public boolean add(ContractDetail contractDetail) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD);
            callableStatement.setString(1, contractDetail.getContract().getId());
            callableStatement.setString(2, contractDetail.getAttachFacility().getId());
            callableStatement.setString(3, contractDetail.getQuantity());

            return callableStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
