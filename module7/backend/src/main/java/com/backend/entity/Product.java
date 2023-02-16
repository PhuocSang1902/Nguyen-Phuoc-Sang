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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long code;
    private String name;
    private String description;
    private int coast;
    private int amountInStore;
    private String publisher;
    private String kindOfBook;
    private String author;
    private String numberOfPages;
    private boolean flagDeleted;
    @OneToMany(mappedBy = "product")
    private Set<Image> imageSet;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<OrderProduct> orderProductSet;

}
