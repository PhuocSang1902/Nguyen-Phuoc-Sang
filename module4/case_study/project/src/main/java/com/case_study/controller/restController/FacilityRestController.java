package com.case_study.controller.restController;

import com.case_study.dtoView.FacilityView;
import com.case_study.model.customer.Customer;
import com.case_study.model.facility.Facility;
import com.case_study.model.facility.FacilityType;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.facility.IFacilityService;
import com.case_study.service.facility.IFacilityTypeService;
import com.case_study.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("facilities")
@CrossOrigin("*")
public class FacilityRestController {

    IFacilityService facilityService;
    IFacilityTypeService facilityTypeService;
    IRentTypeService rentTypeService;


    public FacilityRestController(IFacilityService facilityService, IFacilityTypeService facilityTypeService, IRentTypeService rentTypeService) {
        this.facilityService = facilityService;
        this.facilityTypeService = facilityTypeService;
        this.rentTypeService = rentTypeService;
    }

    @GetMapping("")
    public ResponseEntity<Page<FacilityView>> showList(@RequestParam(defaultValue = "") String facilityName,
                                                       @RequestParam(defaultValue = "-1") int facilityTypeId,
                                                       @PageableDefault(size = 100) Pageable pageable) {
        Page<FacilityView> facilityList = facilityService.showList(facilityName, facilityTypeId, pageable);
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity saveFacility(@RequestBody Facility facility) {
        facilityService.save(facility);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity saveFacility(@PathVariable("id") int id, @RequestBody Facility facility) {
        facilityService.save(facility);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> showFacilityById(@PathVariable("id") int id) {
        Optional<Facility> facility = facilityService.findById(id);
        if (facility.isPresent()) {
            return new ResponseEntity<>(facility.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeFacility(@PathVariable("id") Integer id) {
        Optional<Facility> facility = facilityService.findById(id);
        if (facility.isPresent()) {
            facilityService.removeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("select-list")
    public ResponseEntity<List<Facility>> showList() {
        List<Facility> facilityList = facilityService.showListSelect();
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }
}
