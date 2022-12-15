package com.case_study.model.employee;

import com.case_study.model.contract.Contract;
import com.case_study.model.user.UserEmployee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE employee SET flag_remove = false WHERE id = ?")
@Where(clause = "flag_remove = true")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthday;
    private String idCard;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String address;
    @ManyToOne
    private Position position;
    @ManyToOne
    private EducationDegree educationDegree;
    @ManyToOne
    private Division division;
    private boolean flagRemove = true;
    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private Set<Contract> contractSet;
    @OneToOne(mappedBy = "employee")
    private UserEmployee user;
}
