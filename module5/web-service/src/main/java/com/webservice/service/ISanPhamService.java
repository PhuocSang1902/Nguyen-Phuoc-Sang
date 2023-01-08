package com.webservice.service;

import com.webservice.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> getAll(Pageable pageable);
}
