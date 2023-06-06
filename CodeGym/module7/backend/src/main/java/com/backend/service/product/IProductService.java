package com.backend.service.product;

import com.backend.dto.product.ProductHome;
import com.backend.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<ProductHome> findAll(String search, String kindOfBook, Pageable pageable);

    Optional<Product> findById(int id);
}
