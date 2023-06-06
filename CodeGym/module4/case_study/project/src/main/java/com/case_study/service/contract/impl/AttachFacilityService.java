package com.case_study.service.contract.impl;

import com.case_study.model.contract.AttachFacility;
import com.case_study.model.contract.ContractDetail;
import com.case_study.repository.contract.IAttachFacilityRepository;
import com.case_study.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public Optional<AttachFacility> findById(Integer id) {
        return attachFacilityRepository.findById(id);
    }
}
