package com.webservice.service;

import com.webservice.dto.LoHangDto;
import com.webservice.model.LoHang;
import com.webservice.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILoHangService {
    Page<LoHangDto> getAll(Pageable pageable);

    void create(LoHang loHang);

    void delete(int id);

    LoHang getById(int id);

    void edit(LoHang loHang, Integer idLoHang);
}
