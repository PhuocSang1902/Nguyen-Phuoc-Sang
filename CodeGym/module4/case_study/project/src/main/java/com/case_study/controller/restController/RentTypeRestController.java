package com.case_study.controller.restController;

import com.case_study.model.facility.FacilityType;
import com.case_study.model.facility.RentType;
import com.case_study.service.facility.IFacilityTypeService;
import com.case_study.service.facility.IRentTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rent-types")
@CrossOrigin("*")
public class RentTypeRestController {
    private IRentTypeService rentTypeService;

    public RentTypeRestController(IRentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    @GetMapping("")
    public ResponseEntity<List<RentType>> showList() {
        List<RentType> rentTypeList = rentTypeService.findAll();
        return new ResponseEntity<>(rentTypeList, HttpStatus.OK);
    }
}
