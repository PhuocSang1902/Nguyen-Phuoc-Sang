package com.case_study.dto;

import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class CustomerDto implements Validator {

    private Integer id;
    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "{Invalid}")
    private String name;
    private CustomerType customerType;
    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2})$", message = "{Invalid}")
    private String birthday;
    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^(Nam)|(Nữ)$", message = "{Invalid}")
    private String gender;
    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "{Invalid}")
    private String idCard;
    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^(\\+84\\d{9})|(0\\d{9})$", message = "{Invalid}")
    private String phoneNumber;
    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b$", message = "{Invalid}")
    private String email;
    @NotBlank(message = "{NotEmpty}")
    private String address;
    private boolean flagRemove = true;

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlagRemove() {
        return flagRemove;
    }

    public void setFlagRemove(boolean flagRemove) {
        this.flagRemove = flagRemove;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Cấu hình validate
        CustomerDto customer = (CustomerDto) target;
//        Validate tuổi  lớn hơn 18 và nhỏ hơn 100
        String stringDate = customer.getBirthday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (!("").equals(stringDate)){
            LocalDate birthday = LocalDate.parse(stringDate, formatter);
            LocalDate now = LocalDate.now();
            int age = Period.between(birthday, now).getYears();
            if (age < 18 || age > 100) {
                errors.rejectValue("birthday", "BirthdayValid","Invalid");
            }
        }
    }
}
