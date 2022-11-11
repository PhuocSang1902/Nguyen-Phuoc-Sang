package repository;

import model.contract.Contract;

public interface IContractRepository {
    Contract findById(int id);
}
