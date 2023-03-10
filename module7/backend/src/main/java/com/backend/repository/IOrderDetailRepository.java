package com.backend.repository;

import com.backend.dto.cart.CartList;
import com.backend.dto.order.OrderDetailList;
import com.backend.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    OrderDetail save(OrderDetail orderDetail);

    @Query(value = "select od.id,\n" +
            "       p.id                            as idProduct,\n" +
            "       p.code,\n" +
            "       p.name,\n" +
            "       p.cost,\n" +
            "       i.url                           as image,\n" +
            "       od.number_of_product            as numberOfProduct,\n" +
            "       (od.number_of_product * p.cost) as totalCost\n" +
            "from order_detail od\n" +
            "         join orders o on o.id = od.orders_id\n" +
            "         join product p on p.id = od.product_id\n" +
            "         join image i on p.id = i.product_id\n" +
            "where o.flag_deleted = false\n" +
            "  and od.orders_id = :id\n" +
            "group by p.id", nativeQuery = true)
    List<OrderDetailList> findAllByOrder(@Param("id") int id);
}
