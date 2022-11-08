package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getList();

    boolean remove(String id);

    Customer findById(int id);

    boolean edit(int id, Customer customer);
}
