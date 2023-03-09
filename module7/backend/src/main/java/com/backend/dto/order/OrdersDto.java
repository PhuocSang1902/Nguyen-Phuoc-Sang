package com.backend.dto.order;

import com.backend.dto.customer.CustomerDto;
import com.backend.entity.customer.Customer;
import com.backend.entity.order.OrderDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {
    private Integer id;
    private String deliveryAddress;
    private String deliveryPhone;
    private boolean paymentStatus;
    private boolean flagDeleted = false;
    private Set<OrderDetailDto> orderDetailSet;
    private CustomerDto customer;
    private double orderValue;
}
