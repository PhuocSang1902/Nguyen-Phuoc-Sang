package com.case_study.controller.restController;

import com.case_study.dtoView.ContractDetailView;
import com.case_study.model.customer.CustomerType;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer-types")
@CrossOrigin("*")
public class CustomerTypeRestController {
    private ICustomerTypeService customerTypeService;

    public CustomerTypeRestController( ICustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerType>> showList() {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
    }
}
