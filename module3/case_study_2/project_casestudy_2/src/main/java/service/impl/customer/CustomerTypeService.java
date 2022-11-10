package service.impl.customer;

import model.customer.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.customer.CustomerTypeRepository;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {

    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> getList() {
        return customerTypeRepository.getList();
    }
}
