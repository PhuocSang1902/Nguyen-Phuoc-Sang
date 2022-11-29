package com.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
    private Integer id;
    @NotBlank
    @Size(min = 5, max = 45, message = "Có ít nhất 5 ký tự và tối đa 45 ký tự")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45, message = "Có ít nhất 5 ký tự và tối đa 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^\\d{10}$", message = "{invalid}")
    private String phoneNumber;
    @Min(value = 18, message = "{ageBigger18}")
    private Integer age;
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "{invalid}")
    private String email;

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
}
