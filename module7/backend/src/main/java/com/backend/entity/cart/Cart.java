package com.backend.entity.cart;

import com.backend.entity.customer.Customer;
import com.backend.entity.product.Product;
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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_cart",
            joinColumns = { @JoinColumn(name = "cart_id") },
            inverseJoinColumns = {@JoinColumn(name = "product_id") })
    @JsonBackReference
    private Set<Product> productSet;
    @OneToOne
    private Customer customer;
}
