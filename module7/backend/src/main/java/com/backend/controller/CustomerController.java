package com.backend.controller;

import com.backend.entity.customer.Customer;
import com.backend.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("find-customer-by-account")
    public ResponseEntity<Customer> getCustomerByAccount(@RequestParam long id) {
        Optional<Customer> customer = customerService.findByIdAccount(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
