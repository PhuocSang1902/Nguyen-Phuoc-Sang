package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getList();

    Customer findById(String id);
}
