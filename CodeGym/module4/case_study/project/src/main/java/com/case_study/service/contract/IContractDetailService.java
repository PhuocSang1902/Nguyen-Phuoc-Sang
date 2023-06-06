package com.case_study.service.contract;

import com.case_study.dtoView.ContractDetailView;
import com.case_study.model.contract.ContractDetail;
import com.case_study.model.customer.Customer;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetailView> showList(Integer contractId);

    void save(ContractDetail contractDetail);
}
