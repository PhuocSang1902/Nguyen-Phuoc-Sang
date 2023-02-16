package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long code;
    private String orderDate;
    private boolean status;
    private boolean paymentStatus;
    private String deliveryAddress;
    private String deliveryPhone;
    private boolean flagDeleted;
    @OneToMany(mappedBy = "orders")
    @JsonBackReference
    private Set<OrderProduct> orderProductSet;
}
