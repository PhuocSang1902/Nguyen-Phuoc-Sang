package com.case_study.service.facility;

import com.case_study.model.facility.FacilityType;

import java.util.List;
import java.util.Optional;

public interface IFacilityTypeService {
    Optional<FacilityType> findById(int facilityTypeId);

    List<FacilityType> findAll();
}
