package com.backend.repository;

import com.backend.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select c.id,\n" +
            "       p.id as idProduct,\n" +
            "       p.code,\n" +
            "       p.name,\n" +
            "       p.cost,\n" +
            "       i.url,\n" +
            "       c2.id as idCustomer,\n" +
            "       c.number_of_product as numberOfProduct\n" +
            "from cart c\n" +
            "         join customer c2 on c2.id = c.customer_id\n" +
            "         join account a on a.id_account = c2.account_id_account\n" +
            "         join product p on p.id = c.product_id\n" +
            "         join image i on p.id = i.product_id\n" +
            "where a.id_account = :id\n" +
            "  and p.flag_deleted = false\n" +
            "  and c2.flag_deleted = false\n" +
            "group by c.id, p.id, p.code, p.name, p.cost, c2.id, c.number_of_product", nativeQuery = true)
    List<Cart> findCartByCustomerAccountId(@Param("id") Long id);
}
