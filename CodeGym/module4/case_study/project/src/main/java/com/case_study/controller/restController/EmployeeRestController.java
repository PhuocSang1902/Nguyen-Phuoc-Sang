package com.case_study.controller.restController;

import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import com.case_study.service.employee.IEmployeeService;
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
@RequestMapping("employees")
@CrossOrigin("*")
public class EmployeeRestController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping("")
    public ResponseEntity<List<Employee>> showList() {
        List<Employee> employeeList = employeeService.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
