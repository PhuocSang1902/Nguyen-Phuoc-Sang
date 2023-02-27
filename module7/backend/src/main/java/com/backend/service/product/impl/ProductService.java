package com.backend.service.product.impl;

import com.backend.dto.product.ProductHome;
import com.backend.entity.product.Product;
import com.backend.repository.IProductRepository;
import com.backend.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<ProductHome> findAll(String search,String kindOfBook, Pageable pageable) {
        return this.productRepository.findAll(search, kindOfBook, pageable);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }
}
