package service.impl.contract;

import model.contract.Contract;
import repository.IContractRepository;
import repository.impl.contract.ContractRepository;
import service.IContractService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Contract> search(String search) {
        return contractRepository.search(search);
    }

    @Override
    public Map<Contract, String> getListWithValue() {
        return contractRepository.getListWithValue();
    }

    @Override
    public Map<String, String> add(Contract contract) {
        Map<String, String> errorMap = new HashMap<>();

        if (errorMap.isEmpty()){
            contractRepository.add(contract);
        }
        return errorMap;
    }
}
