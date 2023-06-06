package com.case_study.controller.restController;

import com.case_study.dtoView.ContractView;
import com.case_study.model.contract.Contract;
import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import com.case_study.service.contract.IContractService;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.employee.IEmployeeService;
import com.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contracts")
@CrossOrigin("*")
public class ContractRestController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<Page<ContractView>> showList(@PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "-1") int customerId) {
        Page<ContractView> contractList = contractService.showList(customerId, pageable);
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }
    @GetMapping("by-customer/{id}")
    public ResponseEntity<List<ContractView>> showListByCustomer(@PathVariable("id") int customerId) {
        List<ContractView> contractList = contractService.showListByCustomer(customerId);
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity create(@RequestBody Contract contract){
        Optional<Customer> customer = customerService.findById(contract.getCustomer().getId());
        Optional<Facility> facility = facilityService.findById(contract.getFacility().getId());
        Optional<Employee> employee = employeeService.findById(contract.getEmployee().getId());
        contract.setCustomer(customer.get());
        contract.setFacility(facility.get());
        contract.setEmployee(employee.get());
        contractService.save(contract);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
