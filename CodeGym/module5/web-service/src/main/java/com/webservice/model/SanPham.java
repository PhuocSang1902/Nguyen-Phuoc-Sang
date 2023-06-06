package com.webservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ten;
    private String xuatXu;
    private double giaTien;
    private String donVi;
    @OneToMany(mappedBy = "sanPham")
    @JsonBackReference
    private Set<LoHang> loHangSet;
}
