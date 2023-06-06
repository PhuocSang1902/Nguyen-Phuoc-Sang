package case_study_furama_resort_module_2.models.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String code;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String code, String fullName, LocalDate dateOfBirth, String gender, String idNumber, String phoneNumber, String email) {
        this.code = code;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    @Override
    public String toString() {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return
                        "code='" + code + '\'' +
                        ", fullName='" + fullName + '\'' +
                        ", dateOfBirth='" + dateOfBirth.format(fm)+ '\'' +
                        ", gender='" + gender + '\'' +
                        ", idNumber=" + idNumber +
                        ", phoneNumber=" + phoneNumber +
                        ", Email='" + email + '\'';
    }
}
