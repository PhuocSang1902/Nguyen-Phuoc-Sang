package com.backend.repository;

import com.backend.dto.order.OrderList;
import com.backend.entity.order.OrderDetail;
import com.backend.entity.order.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface IOrderRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "select o.id,\n" +
            "       o.payment_status   as paymentStatus,\n" +
            "       o.delivery_address as deliveryAddress,\n" +
            "       o.delivery_phone   as deliveryPhone,\n" +
            "       o.order_value      as orderValue,\n" +
            "       o.order_date       as orderDate,\n" +
            "       o.status\n" +
            "from orders o\n" +
            "         join customer c on c.id = o.customer_id\n" +
            "where c.id = :id\n" +
            "  and o.flag_deleted = false\n" +
            "  and c.flag_deleted = false\n" +
            "order by o.id desc", nativeQuery = true)
    List<OrderList> findAllByIdCustomer(@Param("id") int id);

    Optional<Orders> findByIdAndAndPaymentStatusIsFalse(int id);
}
