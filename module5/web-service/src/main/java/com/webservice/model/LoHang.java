package com.webservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoHang;
    private String ma;
    @ManyToOne
    private SanPham sanPham;
    private int soLuong;
    private String ngayNhapHang;
    private String ngaySanXuat;
    private String ngayHetHan;

}
