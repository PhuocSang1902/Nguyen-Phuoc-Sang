package com.webservice.controller;

import com.webservice.model.SanPham;
import com.webservice.service.ISanPhamService;
import com.webservice.service.impl.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("san-pham")
@CrossOrigin("*")
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping("")
    public ResponseEntity<List<SanPham>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        List<SanPham> sanPhamList = sanPhamService.getAll(pageable);
        return new ResponseEntity<>(sanPhamList, HttpStatus.OK);
    }
}
