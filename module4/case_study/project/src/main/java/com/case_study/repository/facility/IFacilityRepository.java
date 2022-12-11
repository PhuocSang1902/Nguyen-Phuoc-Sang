package com.case_study.repository.facility;

import com.case_study.model.facility.Facility;
import com.case_study.model.facility.FacilityType;
import com.case_study.dtoView.FacilityView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<FacilityView> findByNameContaining(String name, Pageable pageable);
    Page<FacilityView> findByNameContainingAndFacilityType(String name, FacilityType facilityType, Pageable pageable);
}
