package com.backend.service.product.impl;

import com.backend.dto.product.ProductHome;
import com.backend.repository.IProductRepository;
import com.backend.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<ProductHome> findAll(String search, Pageable pageable) {
        return this.productRepository.findAll(search, pageable);
    }
}
