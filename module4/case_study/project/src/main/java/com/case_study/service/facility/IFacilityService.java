package com.case_study.service.facility;

import com.case_study.model.facility.Facility;
import com.case_study.service.IGenericService;
import com.case_study.dtoView.FacilityView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService extends IGenericService<Facility> {
    Page<FacilityView> showList(String facilityName, int facilityTypeId, Pageable pageable);
}
