package service;

import model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> getList();

    List<ContractDetail> getListInContract(int contractId);

    boolean add(ContractDetail contractDetail);
}
