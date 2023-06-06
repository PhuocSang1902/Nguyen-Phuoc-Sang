package com.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Integer id;
    @NotBlank
    @Size(min = 5, max = 45, message = "Có ít nhất 5 ký tự và tối đa 45 ký tự")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45, message = "Có ít nhất 5 ký tự và tối đa 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^\\d{10}$", message = "{invalid}")
    private String phoneNumber;
//    @Min(value = 18, message = "{ageBigger18}")
    @NotNull(message = "null các bạn")
    private Integer age;
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "{invalid}")
    private String email;
    @NotNull(message = "null các bạn")
    private int number;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
//        if (userDto.age==null) {
//            errors.rejectValue("age","age.errors",
//                    "Tuổi không hợp lệ (a>= 18)");
//        }
    }
}
