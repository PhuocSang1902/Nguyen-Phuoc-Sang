package com.backend.entity.product;

import com.backend.entity.cart.Cart;
import com.backend.entity.order.OrderDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long code;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private int cost;
    private int amountInStore;
    private String publisher;
    private String issuingCompany;
    private String publicationDate;
    private String kindOfBook;
    private String author;
    private String coverType;
    private String numberOfPages;
    private boolean flagDeleted;
    @OneToMany(mappedBy = "product")
    private Set<Image> imageSet;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<OrderDetail> orderDetailSet;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Cart> carts;
}
