package com.case_study.viewDto;

import com.case_study.model.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Builder
@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class CustomerView {
    private Integer id;
    private String name;
    private CustomerType customerType;
    private String birthday;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean flagRemove = true;


}
