package com.case_study.controller.restController;

import com.case_study.dtoView.ContractDetailView;
import com.case_study.model.contract.AttachFacility;
import com.case_study.model.contract.Contract;
import com.case_study.model.contract.ContractDetail;
import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import com.case_study.service.contract.IAttachFacilityService;
import com.case_study.service.contract.IContractDetailService;
import com.case_study.service.contract.IContractService;
import com.case_study.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contract-details")
@CrossOrigin("*")
public class ContractDetailRestController {
    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachFacilityService attachFacilityService;

    @GetMapping("{id}")
    public ResponseEntity<List<ContractDetailView>> showList(@PathVariable("id") int contractId) {
        List<ContractDetailView> contractDetailViewList = contractDetailService.showList(contractId);
        return new ResponseEntity<>(contractDetailViewList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody ContractDetail contractDetail) {
        Optional<Contract> contract = contractService.findById(contractDetail.getContract().getId());
        Optional<AttachFacility> attachFacility = attachFacilityService.findById(contractDetail.getAttachFacility().getId());
        contractDetail.setContract(contract.get());
        contractDetail.setAttachFacility(attachFacility.get());
        contractDetailService.save(contractDetail);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
