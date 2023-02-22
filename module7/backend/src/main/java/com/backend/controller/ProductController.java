package com.backend.controller;

import com.backend.dto.product.ProductHome;
import com.backend.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class ProductController {
    @Autowired
    IProductService productService;

    @RequestMapping("public/product/list")
    public ResponseEntity<Page<ProductHome>> findAll(@RequestParam(defaultValue = "")String search, @PageableDefault(size = 8)Pageable pageable){
        Page<ProductHome> productHomePage = this.productService.findAll(search, pageable);
        return new ResponseEntity<>(productHomePage, HttpStatus.OK);
    }
}
