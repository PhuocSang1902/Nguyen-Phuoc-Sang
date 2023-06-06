package service.impl.customer;

import model.contract.Contract;
import model.customer.Customer;
import repository.ICustomerRepository;
import repository.impl.customer.CustomerRepository;
import service.ICustomerService;
import validation.CustomerValidation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> getList() {
        return customerRepository.getList();
    }

    @Override
    public Customer findById(int id) {

        return customerRepository.findById(id);
    }

    @Override
    public boolean remove(String id) {
        return customerRepository.remove(id);
    }

    @Override
    public boolean edit(int id, Customer customer) {
        return customerRepository.edit(id, customer);
    }

    @Override
    public Map<String, String> add(Customer customer) {
        Map<String,String> errorMap = new HashMap<>();
        if("".equals(customer.getName())){
            errorMap.put("customerName", "Không được để trống");
        }else if (!CustomerValidation.checkName(customer.getName())){
            errorMap.put("customerName", "Không đúng định dạng");
        }
        if("".equals(customer.getPhoneNumber())){
            errorMap.put("phoneNumber", "Không được để trống");
        }else if (!CustomerValidation.checkPhoneNumber(customer.getPhoneNumber())){
            errorMap.put("phoneNumber", "Không đúng định dạng");
        }
        if("".equals(customer.getIdCard())){
            errorMap.put("idCard", "Không được để trống");
        }else if (!CustomerValidation.checkIdCard(customer.getIdCard())){
            errorMap.put("idCard", "Không đúng định dạng");
        }
        if("".equals(customer.getEmail())){
            errorMap.put("email", "Không được để trống");
        }else if (!CustomerValidation.checkEmail(customer.getEmail())){
            errorMap.put("email", "Không đúng định dạng");
        }
        if("".equals(customer.getAddress())){
            errorMap.put("address", "Không được để trống");
        }
        if("".equals(customer.getGender())){
            errorMap.put("gender", "Không được để trống");
        }
        if("".equals(customer.getBirthday())){
            errorMap.put("birthday", "Không được để trống");
        }
        if("".equals(customer.getCustomerType())){
            errorMap.put("customerType", "Không được để trống");
        }
        if (errorMap.isEmpty()){
            customerRepository.add(customer);
        }

        return errorMap;
    }

    @Override
    public List<Customer> search(String search) {
        return customerRepository.search(search);
    }

    @Override
    public Map<Contract, Customer> getListUseFacility() {
        return customerRepository.getListUseFacility();
    }
}
