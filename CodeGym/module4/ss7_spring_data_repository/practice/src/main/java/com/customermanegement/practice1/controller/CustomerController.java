package com.customermanegement.practice1.controller;

import com.customermanegement.practice1.model.Customer;
import com.customermanegement.practice1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("create-customer")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("create-customer")
    public String createCustomer(@ModelAttribute("customer")Customer customer, Model model){
        customerService.save(customer);
        String mess = "Add new successfully";
        model.addAttribute("mess", mess);
        return "/create";
    }
    @GetMapping("")
    public String showListCustomer(Model model){
        Iterable<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "/list";
    }
    @GetMapping("edit-customer/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            model.addAttribute("customer", customer.get());
            return "/edit";
        }
        return "redirect:/";
    }
    @PostMapping("edit-customer")
    public String EditCustomer(@ModelAttribute("customer")Customer customer, Model model){
        customerService.save(customer);
        String mess = "Edit successfully";
        return "redirect:/";
    }
    @GetMapping("delete-customer/{id}")
    public String deleteCustomerById(@PathVariable("id")Integer id){
        customerService.remove(id);
        return "redirect:/";

    }
}
