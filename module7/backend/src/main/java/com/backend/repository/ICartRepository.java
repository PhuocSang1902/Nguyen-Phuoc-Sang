package com.backend.repository;

import com.backend.dto.cart.CartList;
import com.backend.dto.cart.CartTotal;
import com.backend.entity.cart.Cart;
import com.backend.entity.customer.Customer;
import com.backend.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Integer>  {
    @Query(value = "select c.id,\n" +
            "       p.id as idProduct,\n" +
            "       p.code,\n" +
            "       p.name,\n" +
            "       p.cost,\n" +
            "       i.url as image,\n" +
            "       c2.id as idCustomer,\n" +
            "       c.number_of_product as numberOfProduct,\n" +
            "       (c.number_of_product * p.cost) as totalCost\n" +
            "from cart c\n" +
            "         join customer c2 on c2.id = c.customer_id\n" +
            "         join account a on a.id_account = c2.account_id_account\n" +
            "         join product p on p.id = c.product_id\n" +
            "         join image i on p.id = i.product_id\n" +
            "where a.id_account = :id\n" +
            "  and p.flag_deleted = false\n" +
            "  and c2.flag_deleted = false\n" +
            "group by c.id, p.id, p.code, p.name, p.cost, c2.id, c.number_of_product", nativeQuery = true)
    List<CartList> findCartByCustomerAccountId(@Param("id") Long id);

    Optional<Cart> findCartByCustomer_IdAndProduct_Id(Integer idCustomer, Integer idProduct);

    @Query(value = "select count(c.id) as totalProduct, sum(c.number_of_product * p.cost) as totalCost\n" +
            "from cart c\n" +
            "         join customer c2 on c2.id = c.customer_id\n" +
            "         join account a on a.id_account = c2.account_id_account\n" +
            "         join product p on p.id = c.product_id\n" +
            "where c2.account_id_account = :id", nativeQuery = true)
    Optional<CartTotal> totalCartByIdAccount(@Param("id") Long id);
}
