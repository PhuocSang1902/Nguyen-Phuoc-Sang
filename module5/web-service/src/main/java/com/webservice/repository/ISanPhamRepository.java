package com.webservice.repository;

import com.webservice.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
    @Query(value = "select * from san_pham",
            nativeQuery = true)
    List<SanPham> getAll(Pageable pageable);
}
