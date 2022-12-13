package com.case_study.controller;

import com.case_study.dto.CustomerDto;
import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
import com.case_study.dtoView.CustomerView;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final ICustomerService customerService;
    private ICustomerTypeService customerTypeService;

    public CustomerController(ICustomerService customerService, ICustomerTypeService customerTypeService) {
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "")String customerName,@RequestParam(defaultValue = "")String email,@RequestParam(defaultValue = "-1")int customerTypeId,@PageableDefault(size = 5) Pageable pageable, Model model){
        Page<CustomerView> customerList = customerService.showList(customerName,email,customerTypeId,pageable);
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerName", customerName);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/list";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){
        Customer customer = Customer.builder().build();
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/form";
    }
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            CustomerDto customerDto = CustomerDto.builder().build();
            BeanUtils.copyProperties(customer.get(), customerDto);
            model.addAttribute("customer", customerDto);
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "/customer/form";
        }
        return "redirect:/customer";
    }
    @PostMapping("save")
    public String saveCustomer(@Validated @ModelAttribute("customer")CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto, bindingResult);
        if(bindingResult.hasErrors()){
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            model.addAttribute("mess","Thông tin không chính xác");
            return "/customer/form";
        }
        Customer customer = Customer.builder().build();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Lưu thành công");
        return "redirect:/customer";
    }
    @GetMapping("remove")
    public String removeCustomer(@RequestParam("id")Integer id, RedirectAttributes redirectAttributes){
        customerService.removeById(id);
        redirectAttributes.addFlashAttribute("mess","Xoá thành công");
        return "redirect:/customer";
    }
}
