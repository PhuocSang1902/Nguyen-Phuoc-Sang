package service.customer;

import model.Customer;
import repository.ICustomerRepository;
import repository.customer.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> getList() {
        return customerRepository.getList();
    }

    @Override
    public Customer findById(String id) {
        List<Customer> customerList = customerRepository.getList();
        Customer customer = new Customer();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)){
                customer = customerList.get(i);
                break;
            }
        }
        return customer;
    }
}
