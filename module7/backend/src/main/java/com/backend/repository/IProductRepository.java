package com.backend.repository;


import com.backend.dto.product.ProductHome;
import com.backend.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p.id, p.code, p.name, p.cost, i.url as image\n" +
            "from product p\n" +
            "         left join image i on p.id = i.product_id\n" +
            "where flag_deleted = false\n" +
            "  and (p.author like concat('%', :search, '%')\n" +
            "  or p.name like concat('%', :search, '%')\n" +
            "  or p.kind_of_book like concat('%', :kindOfBook, '%'))\n" +
            "group by i.product_id\n" +
            "order by p.id desc",
            nativeQuery = true,
            countQuery = "select p.id, p.code, p.name, p.cost, i.url as image\n" +
                    "from product p\n" +
                    "         left join image i on p.id = i.product_id\n" +
                    "where flag_deleted = false\n" +
                    "  and (p.author like concat('%', :search, '%')\n" +
                    "  or p.name like concat('%', :search, '%')\n" +
                    "  or p.kind_of_book like concat('%', :kindOfBook, '%'))\n" +
                    "group by i.product_id\n" +
                    "order by p.id desc")
    Page<ProductHome> findAll(@Param("search") String search,@Param("kindOfBook") String kindOfBook, Pageable pageable);
}
