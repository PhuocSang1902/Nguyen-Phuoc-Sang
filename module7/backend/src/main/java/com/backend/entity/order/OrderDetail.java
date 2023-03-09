package com.backend.entity.order;

import com.backend.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE order_detail SET flag_deleted = true WHERE id = ?")
@Where(clause = "flag_deleted = false")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Product product;
    @ManyToOne
    @JsonBackReference
    private Orders orders;
    private int numberOfProduct;
    private boolean flagDeleted = false;
}
