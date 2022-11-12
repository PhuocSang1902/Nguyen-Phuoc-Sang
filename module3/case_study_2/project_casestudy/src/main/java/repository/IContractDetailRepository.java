package repository;

import model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {
    List<ContractDetail> getList();

    List<ContractDetail> getListInContract(int contractId);
}
