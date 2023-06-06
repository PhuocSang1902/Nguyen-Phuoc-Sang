package repository;

import model.contract.Contract;

import java.util.List;
import java.util.Map;

public interface IContractRepository {
    Contract findById(int id);

    List<Contract> getList();

    Map<Contract, String> getListWithValue();

    List<Contract> search(String search);

    boolean add(Contract contract);
}
