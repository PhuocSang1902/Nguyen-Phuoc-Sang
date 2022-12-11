package com.case_study.service.facility.impl;

import com.case_study.model.facility.FacilityType;
import com.case_study.repository.facility.IFacilityTypeRepository;
import com.case_study.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    IFacilityTypeRepository facilityTypeRepository;
    @Override
    public Optional<FacilityType> findById(int facilityTypeId) {
        return facilityTypeRepository.findById(facilityTypeId);
    }

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
