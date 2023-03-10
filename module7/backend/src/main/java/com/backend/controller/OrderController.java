package com.backend.controller;

import com.backend.dto.order.OrderDetailDto;
import com.backend.dto.order.OrderDetailList;
import com.backend.dto.order.OrderList;
import com.backend.dto.order.OrdersDto;
import com.backend.entity.cart.Cart;
import com.backend.entity.customer.Customer;
import com.backend.entity.order.OrderDetail;
import com.backend.entity.order.Orders;
import com.backend.service.cart.ICartService;
import com.backend.service.customer.ICustomerService;
import com.backend.service.order.IOrderDetailService;
import com.backend.service.order.IOrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
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
    public ResponseEntity<Orders> updatePaymentStatus(@RequestBody int id){
        Optional<Orders> ordersOptional = orderService.findById(id);
        if (ordersOptional.isPresent()){
            ordersOptional.get().setPaymentStatus(true);
            orderService.save(ordersOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("by-id/{id}")
    public ResponseEntity<Orders> getById(@PathVariable int id){
        Optional<Orders> ordersOptional = orderService.findById(id);
        if (ordersOptional.isPresent()){
            return new ResponseEntity<>(ordersOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("detail-list/{id}")
    public ResponseEntity<List<OrderDetailList>> getOrderDetailList(@PathVariable int id){
        Optional<Orders> ordersOptional = orderService.findById(id);
        if (ordersOptional.isPresent()){
            List<OrderDetailList> orderDetailList = orderDetailService.getListByOrder(id);
            return new ResponseEntity<>(orderDetailList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<List<OrderList>> getOrderList(@PathVariable int id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()){
            List<OrderList> orderList = orderService.getListByIdCustomer(id);
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int id){
        Optional<Orders> ordersOptional = orderService.findByIdPaymentStatus(id);
        if (ordersOptional.isPresent()){
            return new ResponseEntity<>(ordersOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
