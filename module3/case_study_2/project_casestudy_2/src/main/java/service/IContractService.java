package service;

import model.contract.Contract;

import java.util.List;

public interface IContractService {

    Contract findById(int id);

    List<Contract> getList();

    List<Contract> search(String search);
}
