package com.case_study.service.contract.impl;

import com.case_study.model.contract.Contract;
import com.case_study.service.contract.IContractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {


    @Override
    public Optional<Contract> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(Contract contract) {
        return false;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }
}
