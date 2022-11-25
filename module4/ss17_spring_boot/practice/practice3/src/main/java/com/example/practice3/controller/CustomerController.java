package com.example.practice3.controller;

import com.example.practice3.model.Customer;
import com.example.practice3.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    private final ICustomerService customerService;
    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("create-customer")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("create-customer")
    public String saveCustomer(@ModelAttribute("customer")Customer customer, Model model){
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "New customer created successfully");
        return "/create";
    }
    @GetMapping("")
    public String listCustomer(@RequestParam(defaultValue = "") String search, Model model){
        List<Customer> customerList = customerService.findByFirstNameContainingOrLastNameContaining(search, search);
        model.addAttribute("customerList", customerList);
        model.addAttribute("search", search);
        return "/list";
    }
    @GetMapping("edit-customer/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            model.addAttribute("customer", customer);
            return "/edit";
        }else {
            return "/error.404";
        }
    }
    @PostMapping("edit-customer")
    public String editCustomer(@ModelAttribute("customer")Customer customer, Model model){
        customerService.save(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("mess","Customer edit successfully");
        return "/edit";
    }
    @GetMapping("delete-customer/{id}")
//    public String showDeleteForm(@PathVariable("id") Integer id, Model model) {
//        Optional<Customer> customer = customerService.findById(id);
//        if (customer.isPresent()) {
//            model.addAttribute("customer", customer);
//            return "delete";
//
//        } else {
//            return "/error.404";
//        }
    public String showDeleteForm(@PathVariable("id")Integer id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            model.addAttribute("customer", customer.get());
            return "/delete";
        }else {
            return "/error.404";
        }
    }
    @PostMapping("delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/";
    }

}
