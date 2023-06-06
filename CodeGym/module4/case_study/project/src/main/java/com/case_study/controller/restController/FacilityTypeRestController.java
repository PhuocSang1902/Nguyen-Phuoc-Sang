package com.case_study.controller.restController;

import com.case_study.model.customer.CustomerType;
import com.case_study.model.facility.Facility;
import com.case_study.model.facility.FacilityType;
import com.case_study.service.customer.ICustomerTypeService;
import com.case_study.service.facility.IFacilityTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("facility-types")
@CrossOrigin("*")
public class FacilityTypeRestController {
    private IFacilityTypeService facilityTypeService;

    public FacilityTypeRestController( IFacilityTypeService facilityTypeService) {
        this.facilityTypeService = facilityTypeService;
    }

    @GetMapping("")
    public ResponseEntity<List<FacilityType>> showList() {
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        return new ResponseEntity<>(facilityTypeList, HttpStatus.OK);
    }
}
