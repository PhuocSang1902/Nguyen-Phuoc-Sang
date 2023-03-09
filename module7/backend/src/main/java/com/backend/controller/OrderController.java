package com.backend.controller;

import com.backend.dto.order.OrderDetailDto;
import com.backend.dto.order.OrdersDto;
import com.backend.entity.cart.Cart;
import com.backend.entity.customer.Customer;
import com.backend.entity.order.OrderDetail;
import com.backend.entity.order.Orders;
import com.backend.service.cart.ICartService;
import com.backend.service.customer.ICustomerService;
import com.backend.service.order.IOrderDetailService;
import com.backend.service.order.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/order")
public class OrderController {
    @Autowired
    IOrderService orderService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICartService cartService;
    @Autowired
    IOrderDetailService orderDetailService;

    @PostMapping("create")
    public ResponseEntity<Orders> create(@RequestBody OrdersDto ordersDto){
        Optional<Customer> customerOptional = customerService.findById(ordersDto.getCustomer().getId());
        if (customerOptional.isPresent()){
            Orders orders = new Orders();
            BeanUtils.copyProperties(ordersDto, orders);
            orders.setCustomer(customerOptional.get());
            orders = orderService.save(orders);
            Set<OrderDetail> orderDetailSet = new LinkedHashSet<>();
            for (OrderDetailDto item: ordersDto.getOrderDetailSet()) {
                Optional<Cart> cartOptional = cartService.findById(item.getId());
                if (cartOptional.isPresent()){
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setNumberOfProduct(item.getNumberOfProduct());
                    orderDetail.setProduct(cartOptional.get().getProduct());
                    orderDetail.setOrders(orders);
                    orderDetailSet.add(orderDetailService.save(orderDetail));
                    cartService.deleteById(cartOptional.get().getId());
                }
            }
            orders.setOrderDetailSet(orderDetailSet);
            orderService.save(orders);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("pay-onl")
    public ResponseEntity<Orders> updatePaymentStatus(@RequestParam int id){
        Optional<Orders> ordersOptional = orderService.findById(id);
        if (ordersOptional.isPresent()){
            ordersOptional.get().setPaymentStatus(true);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
