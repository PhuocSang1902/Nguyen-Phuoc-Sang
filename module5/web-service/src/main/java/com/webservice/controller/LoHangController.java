package com.webservice.controller;

import com.webservice.dto.LoHangDto;
import com.webservice.model.LoHang;
import com.webservice.service.ILoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lo-hang")
@CrossOrigin("*")
public class LoHangController {
    @Autowired
    private ILoHangService loHangService;

    @GetMapping("")
    public ResponseEntity<Page<LoHangDto>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<LoHangDto> loHangList = loHangService.getAll(pageable);
        return new ResponseEntity<>(loHangList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody LoHang loHang) {
        loHangService.create(loHang);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        loHangService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoHang> getById(@PathVariable("id")int id) {
        LoHang loHang = loHangService.getById(id);
        return new ResponseEntity<>(loHang, HttpStatus.OK);
    }
    @PatchMapping("")
    public ResponseEntity edit(@RequestBody LoHang loHang) {
        loHangService.edit(loHang, loHang.getIdLoHang());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
