package com.case_study.controller;

import com.case_study.dtoView.ContractView;
import com.case_study.dtoView.CustomerView;
import com.case_study.model.contract.Contract;
import com.case_study.model.customer.CustomerType;
import com.case_study.service.contract.IContractService;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
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

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public String showList(@PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "-1") int customerId, Model model) {
        Page<ContractView> contractList = contractService.showList(customerId, pageable);
        model.addAttribute("contractList", contractList);
        return "contract/list";
    }
}
