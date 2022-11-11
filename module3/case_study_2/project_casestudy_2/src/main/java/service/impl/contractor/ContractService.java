package service.impl.contractor;

import model.contract.Contract;
import repository.IContractRepository;
import repository.impl.contract.ContractRepository;
import service.IContractService;

public class ContractService implements IContractService {

    private IContractRepository contractRepository = new ContractRepository();

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }
}
