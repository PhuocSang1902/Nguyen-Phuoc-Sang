package com.backend.controller;

import com.backend.dto.product.ProductHome;
import com.backend.entity.product.Product;
import com.backend.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("public/product/list")
    public ResponseEntity<Page<ProductHome>> findAll(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "") String kindOfBook, @PageableDefault(size = 8) Pageable pageable) {
        Page<ProductHome> productHomePage = this.productService.findAll(search, kindOfBook, pageable);
        if (!productHomePage.isEmpty()) {
            return new ResponseEntity<>(productHomePage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("public/product/detail/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") int id) {
        Optional<Product> productDetail = this.productService.findById(id);
        if (productDetail.isPresent()) {
            return new ResponseEntity<>(productDetail.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
