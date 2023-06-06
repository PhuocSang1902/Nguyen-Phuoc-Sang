package com.backend.entity.customer;

import com.backend.entity.security.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE customer SET flag_deleted = true WHERE id = ?")
@Where(clause = "flag_deleted = false")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String birthday;
    private boolean gender;
    private boolean flagDeleted = false;
    @OneToOne
    private Account account;
}
