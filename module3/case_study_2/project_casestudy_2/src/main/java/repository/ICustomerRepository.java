package repository;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getList();

    boolean remove(String id);

    Customer findById(int id);

    boolean edit(int id, Customer customer);

    boolean add(Customer customer);

    List<Customer> search(String search);

    List<Customer> getListUseFacility();
}
