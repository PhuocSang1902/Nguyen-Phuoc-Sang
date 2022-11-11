package service.impl.contract;

import model.contract.ContractDetail;
import repository.IContractDetailRepository;
import repository.impl.contract.ContractDetailRepository;
import service.IContractDetailService;

import java.util.List;

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
}
