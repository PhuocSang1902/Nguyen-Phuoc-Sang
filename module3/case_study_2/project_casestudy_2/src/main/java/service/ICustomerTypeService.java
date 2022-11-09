package service;

import model.CustomerType;
import service.impl.CustomerTypeService;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> getList();
}
