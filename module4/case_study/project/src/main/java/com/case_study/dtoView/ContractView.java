package com.case_study.dtoView;

import com.case_study.model.contract.ContractDetail;
import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import lombok.*;
import java.util.Set;

public interface ContractView {
     Integer getId();

     String getStartDate();

     String getEndDate();

     Double getDeposit();

     Double getTotalAmount();

     String getEmployeeName();

     String getCustomerName();

     String getFacilityName();
}