package com.case_study.controller.restController;

import com.case_study.model.customer.Customer;
import com.case_study.model.facility.Facility;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("facilities")
@CrossOrigin("*")
public class FacilityRestController {
    @Autowired
    IFacilityService facilityService;
    @GetMapping("")
    public ResponseEntity<List<Facility>> showList() {
        List<Facility> facilityList = facilityService.findAll();
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }
}
