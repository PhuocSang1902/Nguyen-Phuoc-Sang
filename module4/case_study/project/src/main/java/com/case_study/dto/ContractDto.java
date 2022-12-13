package com.case_study.dto;

import com.case_study.model.contract.ContractDetail;
import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private Set<ContractDetail> contractDetailSet;
    private boolean flagRemove = true;
}
