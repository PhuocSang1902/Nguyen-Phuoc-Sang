package repository;

import model.contract.Contract;
import model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {
    List<ContractDetail> getList();

    List<ContractDetail> getListInContract(int contractId);

    boolean add(ContractDetail contractDetail);
}
