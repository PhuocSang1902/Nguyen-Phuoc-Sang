package com.case_study.controller;

import com.case_study.model.customer.Customer;
import com.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model){
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/customer/create-form";
    }
    @PostMapping("create")
    public String saveCreateCustomer(@ModelAttribute("customer")Customer customer, Model model){
        customerService.save(customer);
        model.addAttribute("mess", "Khách hàng được thêm mới thành công!");
        return "/customer/create-form";
    }
    @GetMapping("remove/{id}")
    public String removeCustomer(@PathVariable("id")Integer id){
        customerService.removeById(id);
        return "redirect:/customer";
    }
}
