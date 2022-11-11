package repository;

import model.contract.Contract;

import java.util.List;

public interface IContractRepository {
    Contract findById(int id);

    List<Contract> getList();
}
