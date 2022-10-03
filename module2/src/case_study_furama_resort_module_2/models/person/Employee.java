package case_study_furama_resort_module_2.models.person;

import java.time.LocalDate;

public class Employee extends Person {
    private String qualification;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeCode, String fullName, LocalDate dateOfBirth, String gender, String idNumber, String phoneNumber, String email) {
        super(employeeCode, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
    }

    public Employee(String employeeCode, String fullName, LocalDate dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String qualification, String position, double salary) {
        super(employeeCode, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.qualification = qualification;
        this.position = position;
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString()+
                "qualification='" + qualification + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
