package com.case_study.controller.restController;

import com.case_study.model.contract.AttachFacility;
import com.case_study.model.customer.Customer;
import com.case_study.service.contract.IAttachFacilityService;
import com.case_study.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attach-facilities")
@CrossOrigin("*")
public class AttachFacilityRestController {
    @Autowired
    IAttachFacilityService attachFacilityService;
    @GetMapping("")
    public ResponseEntity<List<AttachFacility>> showList() {
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }
}
