package com.case_study.controller.restController;

import com.case_study.dto.CustomerDto;
import com.case_study.dtoView.CustomerUseFacilityView;
import com.case_study.dtoView.CustomerView;
import com.case_study.model.contract.Contract;
import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
@CrossOrigin("*")
public class CustomerRestController {
    private ICustomerService customerService;
    private ICustomerTypeService customerTypeService;

    public CustomerRestController(ICustomerService customerService, ICustomerTypeService customerTypeService) {
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("")
    public ResponseEntity<Page<CustomerView>> showList(@RequestParam(defaultValue = "") String customerName, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "-1") int customerTypeId, @PageableDefault(size = 5) Pageable pageable) {
        Page<CustomerView> customerList = customerService.showList(customerName, email, customerTypeId, pageable);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<Page<CustomerView>> showListBySearch(@PathVariable("search") String searchName, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "-1") int customerTypeId, @PageableDefault(size = 5) Pageable pageable) {
        Page<CustomerView> customerList = customerService.showList(searchName, email, customerTypeId, pageable);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {

        customerService.save(customer);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> showCustomerById(@PathVariable("id") int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCustomer(@PathVariable("id") Integer id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.removeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("use-facility")
    public ResponseEntity<Page<CustomerUseFacilityView>> showListUseFacility(@RequestParam(defaultValue = "") String customerName, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "-1") int customerTypeId, @PageableDefault(size = 5) Pageable pageable) {
        Page<CustomerUseFacilityView> customerList = customerService.showListUseFacility(customerName, email, customerTypeId, pageable);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("use-facility/{search}")
    public ResponseEntity<Page<CustomerUseFacilityView>> showListUseFacilityBySearch(@PathVariable("search") String searchName, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "-1") int customerTypeId, @PageableDefault(size = 5) Pageable pageable) {
        Page<CustomerUseFacilityView> customerList = customerService.showListUseFacility(searchName, email, customerTypeId, pageable);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("select-list")
    public ResponseEntity<List<Customer>> showList() {
        List<Customer> customerList = customerService.showListSelect();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
