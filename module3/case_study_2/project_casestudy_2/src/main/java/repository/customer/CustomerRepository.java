package repository.customer;

import model.Customer;
import repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("1", "Nguyễn Thị Hào", "5", "1970-11-07", "0", "643431213", "0945423362", "thihao07@gmail.com", "23 Nguyễn Hoàng, Đà Nẵng")
        );
    }

    @Override
    public List<Customer> getList() {
        return customerList;
    }
}
