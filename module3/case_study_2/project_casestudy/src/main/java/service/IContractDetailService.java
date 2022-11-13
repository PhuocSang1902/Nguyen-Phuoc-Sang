package service;

import model.contract.ContractDetail;

import java.util.List;
import java.util.Map;

public interface IContractDetailService {
    List<ContractDetail> getList();

    List<ContractDetail> getListInContract(int contractId);

    Map<String, String> add(ContractDetail contractDetail);
}
