package com.case_study.viewDto;

import com.case_study.model.customer.CustomerType;

public interface CustomerView {
    Integer getId();

    String getName();

    String getCustomerType();

    String getBirthday();

    String getGender();

    String getIdCard();

    String getPhoneNumber();

    String getEmail();

    String getAddress();
}
