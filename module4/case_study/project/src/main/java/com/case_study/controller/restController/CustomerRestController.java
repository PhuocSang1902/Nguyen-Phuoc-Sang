package com.case_study.controller.restController;

import com.case_study.model.contract.Contract;
import com.case_study.model.customer.Customer;
import com.case_study.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public ResponseEntity<List<Customer>> showList() {
        List<Customer> customerList = customerService.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
