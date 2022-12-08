package com.case_study.service.facility.impl;

import com.case_study.model.facility.Facility;
import com.case_study.service.facility.IFacilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Override
    public Optional<Facility> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(Facility facility) {
        return false;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }
}
