package com.case_study.service.contract;

import com.case_study.dtoView.ContractView;
import com.case_study.model.contract.Contract;
import com.case_study.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService extends IGenericService<Contract> {

    Page<ContractView> showList(int customerId, Pageable pageable);

    List<ContractView> showListByCustomer(int customerId);
}
