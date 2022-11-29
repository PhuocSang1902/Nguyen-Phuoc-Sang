package com.case_study.service.Impl;

import com.case_study.model.contract.Contract;
import com.case_study.service.IContractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {


    @Override
    public Page<Contract> findAllAndByName(String search, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void edit(Integer id) {

    }
}
