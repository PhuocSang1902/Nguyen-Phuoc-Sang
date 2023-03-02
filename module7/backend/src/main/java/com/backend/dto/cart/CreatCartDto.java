package com.backend.dto.cart;

import com.backend.dto.product.ProductDetailDto;
import com.backend.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatCartDto {
    private Integer id;
    private ProductDetailDto productHome;
    private Long idAccount;
    private Integer numberOfProduct;
}
