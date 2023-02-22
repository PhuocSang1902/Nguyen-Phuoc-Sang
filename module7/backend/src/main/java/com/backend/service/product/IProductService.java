package com.backend.service.product;

import com.backend.dto.product.ProductHome;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductHome> findAll(String search, Pageable pageable);
}
