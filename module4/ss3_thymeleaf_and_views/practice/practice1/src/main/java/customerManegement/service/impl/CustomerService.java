package customerManegement.service.impl;

import customerManegement.model.Customer;
import customerManegement.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService implements ICustomerService {

    private static final List<Customer> customerList = new ArrayList<>();
    static{
        customerList.add(new Customer(1, "Sang", "sang@gmail.com", "DaNang"));
        customerList.add(new Customer(2, "Phuong", "phuong@gmail.com", "HaNoi"));
        customerList.add(new Customer(3, "Bao", "bao@gmail.com", "Hue"));
        customerList.add(new Customer(4, "Dat", "dat@gmail.com", "BinhDinh"));
        customerList.add(new Customer(5, "Tuan", "tuan@gmail.com", "HoChiMinh"));
        customerList.add(new Customer(6, "Huy", "huy@gmail.com", "DaLat"));
        customerList.add(new Customer(7, "Khanh", "khanh@gmail.com", "CanTho"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer:customerList) {
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        int index = -1;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == customer.getId()){
                index = i;
                break;
            }
        }
        if (index > -1){
            customerList.set(index, customer);
        }
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        customerList.remove(customer);
    }
}
