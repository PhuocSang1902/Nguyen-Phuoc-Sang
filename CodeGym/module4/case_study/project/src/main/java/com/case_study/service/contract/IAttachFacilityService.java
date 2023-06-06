package com.case_study.service.contract;

import com.case_study.model.contract.AttachFacility;
import com.case_study.model.contract.ContractDetail;

import java.util.List;
import java.util.Optional;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    Optional<AttachFacility> findById(Integer id);
}
