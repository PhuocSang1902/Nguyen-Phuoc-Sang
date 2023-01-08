package com.webservice.repository;

import com.webservice.dto.LoHangDto;
import com.webservice.model.LoHang;
import com.webservice.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ILoHangRepository extends JpaRepository<LoHang, Integer> {
    @Query(value = "SELECT lh.id_lo_hang as idLoHang, lh.ma, lh.ngay_het_han as ngayHetHan, lh.ngay_nhap_hang as ngayNhapHang, lh.ngay_san_xuat as ngaySanXuat, lh.so_luong as soLuong, sp.ten as tenSanPham, sp.gia_tien as giaTien, sp.don_vi as donVi from lo_hang lh join san_pham sp on sp.id = lh.san_pham_id",
            countQuery = "SELECT lh.id_lo_hang as idLoHang, lh.ma, lh.ngay_het_han as ngayHetHan, lh.ngay_nhap_hang as ngayNhapHang, lh.ngay_san_xuat as ngaySanXuat, lh.so_luong as soLuong, sp.ten as tenSanPham, sp.gia_tien as giaTien, sp.don_vi as donVi from lo_hang lh join san_pham sp on sp.id = lh.san_pham_id",
            nativeQuery = true)
    Page<LoHangDto> getAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO lo_hang(ma, ngay_het_han, ngay_nhap_hang, ngay_san_xuat, so_luong, san_pham_id) VALUES (:ma, :ngayHetHan, :ngayNhapHang, :ngaySanXuat, :soLuong, :idSanPham)",
            nativeQuery = true)
    void create(@Param("ma") String ma, @Param("ngayHetHan") String ngayHetHan, @Param("ngayNhapHang") String ngayNhapHang, @Param("ngaySanXuat") String ngaySanXuat, @Param("soLuong") int soLuong, @Param("idSanPham") SanPham sanPham);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lo_hang WHERE id_lo_hang = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "SELECT * FROM lo_hang WHERE id_lo_hang = :id",
            nativeQuery = true)
    LoHang getById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE lo_hang SET ma = :ma, ngay_het_han = :ngayHetHan, ngay_nhap_hang = :ngayNhapHang, ngay_san_xuat = :ngaySanXuat, so_luong = :soLuong, san_pham_id = :idSanPham WHERE id_lo_hang = :id",
            nativeQuery = true)
    void edit(@Param("id") Integer idLoHang, @Param("ma") String ma, @Param("ngayHetHan") String ngayHetHan, @Param("ngayNhapHang") String ngayNhapHang, @Param("ngaySanXuat") String ngaySanXuat, @Param("soLuong") int soLuong, @Param("idSanPham") SanPham sanPham);
}
