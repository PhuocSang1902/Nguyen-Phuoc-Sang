package com.webservice.service.impl;

import com.webservice.dto.LoHangDto;
import com.webservice.model.LoHang;
import com.webservice.model.SanPham;
import com.webservice.repository.ILoHangRepository;
import com.webservice.service.ILoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoHangService implements ILoHangService {
    @Autowired
    ILoHangRepository loHangRepository;

    @Override
    public Page<LoHangDto> getAll(Pageable pageable) {
        return loHangRepository.getAll(pageable);
    }

    @Override
    public void create(LoHang loHang) {
        loHangRepository.create(loHang.getMa(), loHang.getNgayHetHan(), loHang.getNgayNhapHang(), loHang.getNgaySanXuat(), loHang.getSoLuong(), loHang.getSanPham());
    }

    @Override
    public void delete(int id) {
        loHangRepository.delete(id);
    }

    @Override
    public LoHang getById(int id) {
        return loHangRepository.getById(id);
    }

    @Override
    public void edit(LoHang loHang, Integer idLoHang) {
        loHangRepository.edit(idLoHang, loHang.getMa(), loHang.getNgayHetHan(), loHang.getNgayNhapHang(), loHang.getNgaySanXuat(), loHang.getSoLuong(), loHang.getSanPham());
    }
}
