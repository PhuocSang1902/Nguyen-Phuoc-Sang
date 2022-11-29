package com.case_study.service.Impl;

import com.case_study.model.facility.Facility;
import com.case_study.service.IFacilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Override
    public Page<Facility> findAllAndByName(String search, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void edit(Integer id) {

    }
}
