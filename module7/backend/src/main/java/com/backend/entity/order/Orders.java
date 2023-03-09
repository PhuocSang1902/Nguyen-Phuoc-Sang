package com.backend.entity.order;

import com.backend.entity.customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE orders SET flag_deleted = true WHERE id = ?")
@Where(clause = "flag_deleted = false")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderDate = LocalDate.now().toString();
    private boolean status = true;
    private boolean paymentStatus = false;
    private String deliveryAddress;
    private String deliveryPhone;
    private boolean flagDeleted = false;
    private double orderValue;
    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> orderDetailSet;
    @ManyToOne
    private Customer customer;
}
