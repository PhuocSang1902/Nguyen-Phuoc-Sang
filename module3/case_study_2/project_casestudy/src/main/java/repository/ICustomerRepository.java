package repository;

import model.contract.Contract;
import model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerRepository {
    List<Customer> getList();

    boolean remove(String id);

    Customer findById(int id);

    boolean edit(int id, Customer customer);

    boolean add(Customer customer);

    List<Customer> search(String search);

    Map<Contract, Customer> getListUseFacility();
}
