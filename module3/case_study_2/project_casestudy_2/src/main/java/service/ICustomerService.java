package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getList();

    Customer findById(int id);

    boolean remove(String id);

    boolean edit(int id, Customer customer);
}
