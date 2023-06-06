package com.case_study.service.contract.impl;

import com.case_study.dtoView.ContractView;
import com.case_study.model.contract.Contract;
import com.case_study.model.customer.Customer;
import com.case_study.repository.contract.IContractRepository;
import com.case_study.service.contract.IContractService;
import com.case_study.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;
    @Autowired
    ICustomerService customerService;

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public boolean save(Contract contract) {
        contractRepository.save(contract);
        return true;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }

    @Override
    public Page<ContractView> showList(int customerId, Pageable pageable) {
        Optional<Customer> customer = customerService.findById(customerId);
        if (customerId == -1 || !customer.isPresent()) {
            return contractRepository.showList(pageable);
        }
        return contractRepository.showListWithCustomer(customerId,pageable);
    }

    @Override
    public List<ContractView> showListByCustomer(int customerId) {
        return contractRepository.showListWithCustomer(customerId);
    }
}
