package com.case_study.model.customer;

import com.case_study.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE customer SET flag_remove = false WHERE id = ?")
@Where(clause = "flag_remove = true")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private CustomerType customerType;
    private String birthday;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private Set<Contract> contractSet;
    private boolean flagRemove = true;
}
