package com.case_study.dto;

import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import lombok.*;
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

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
