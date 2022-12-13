package com.case_study.service.contract.impl;

import com.case_study.dtoView.ContractDetailView;
import com.case_study.model.contract.ContractDetail;
import com.case_study.repository.contract.IContractDetailRepository;
import com.case_study.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetailView> showList(Integer contractId) {
        return contractDetailRepository.showList(contractId);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
