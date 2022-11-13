package service.impl.contract;

import model.contract.ContractDetail;
import repository.IContractDetailRepository;
import repository.impl.contract.ContractDetailRepository;
import service.IContractDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDetailService implements IContractDetailService {
    private IContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public List<ContractDetail> getList() {
        return contractDetailRepository.getList();
    }

    @Override
    public List<ContractDetail> getListInContract(int contractId) {
        return contractDetailRepository.getListInContract(contractId);
    }

    @Override
    public boolean add(ContractDetail contractDetail) {
        Map<String, String> errorMap = new HashMap<>();

        return contractDetailRepository.add(contractDetail);
    }
}
