package com.case_study.service.facility.impl;

import com.case_study.model.facility.Facility;
import com.case_study.model.facility.FacilityType;
import com.case_study.repository.facility.IFacilityRepository;
import com.case_study.service.facility.IFacilityService;
import com.case_study.service.facility.IFacilityTypeService;
import com.case_study.dtoView.FacilityView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    final
    IFacilityRepository facilityRepository;
    IFacilityTypeService facilityTypeService;

    public FacilityService(IFacilityRepository facilityRepository, IFacilityTypeService facilityTypeService) {
        this.facilityRepository = facilityRepository;
        this.facilityTypeService = facilityTypeService;
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return facilityRepository.findById(id);
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(Facility facility) {
        facilityRepository.save(facility);
        return true;
    }

    @Override
    public boolean removeById(Integer id) {
        facilityRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<FacilityView> showList(String facilityName, int facilityTypeId, Pageable pageable) {
        Optional<FacilityType> facilityType = facilityTypeService.findById(facilityTypeId);
        if (facilityTypeId == -1 || !facilityType.isPresent()) {
            return facilityRepository.findByNameContaining(facilityName, pageable);
        }
        return facilityRepository.findByNameContainingAndFacilityType(facilityName, facilityType.get(), pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public List<Facility> showListSelect() {
        return facilityRepository.findAll();
    }
}
