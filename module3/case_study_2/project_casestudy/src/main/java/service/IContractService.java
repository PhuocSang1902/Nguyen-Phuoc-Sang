package service;

import model.contract.Contract;

import java.util.List;
import java.util.Map;

public interface IContractService {

    Contract findById(int id);

    List<Contract> getList();

    List<Contract> search(String search);

    Map<Contract, String> getListWithValue();

    Map<String, String> add(Contract contract);
}
