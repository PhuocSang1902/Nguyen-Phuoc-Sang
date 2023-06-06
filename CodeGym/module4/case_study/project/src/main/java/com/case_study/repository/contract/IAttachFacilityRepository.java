package com.case_study.repository.contract;

import com.case_study.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
}
