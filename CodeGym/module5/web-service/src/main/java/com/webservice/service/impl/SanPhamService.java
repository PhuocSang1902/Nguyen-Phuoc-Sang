package com.webservice.service.impl;

import com.webservice.model.SanPham;
import com.webservice.repository.ISanPhamRepository;
import com.webservice.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    ISanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll(Pageable pageable) {
        return sanPhamRepository.getAll(pageable);
    }
}
