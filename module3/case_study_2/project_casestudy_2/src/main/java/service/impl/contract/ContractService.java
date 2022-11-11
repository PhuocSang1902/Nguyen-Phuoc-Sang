package service.impl.contract;

import model.contract.Contract;
import repository.IContractRepository;
import repository.impl.contract.ContractRepository;
import service.IContractService;

import java.util.List;

public class ContractService implements IContractService {

    private IContractRepository contractRepository = new ContractRepository();

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public List<Contract> getList() {
        return contractRepository.getList();
    }
}
