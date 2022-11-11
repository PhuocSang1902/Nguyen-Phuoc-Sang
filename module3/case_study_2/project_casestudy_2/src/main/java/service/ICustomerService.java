package service;

import model.contract.Contract;
import model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> getList();

    Customer findById(int id);

    boolean remove(String id);

    boolean edit(int id, Customer customer);

    boolean add(Customer customer);

    List<Customer> search(String search);

    Map<Contract, Customer> getListUseFacility();
}
