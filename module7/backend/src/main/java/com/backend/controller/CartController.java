package com.backend.controller;

import com.backend.dto.cart.CreatCartDto;
import com.backend.entity.cart.Cart;
import com.backend.entity.customer.Customer;
import com.backend.entity.product.Product;
import com.backend.entity.security.Account;
import com.backend.service.cart.ICartService;
import com.backend.service.customer.ICustomerService;
import com.backend.service.product.IProductService;
import com.backend.service.security.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class CartController {
    @Autowired
    ICartService cartService;
    @Autowired
    IProductService productService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IAccountService accountService;

    @PostMapping("user/cart/add-product-to-cart")
    public ResponseEntity<Cart> addProductToCart(@RequestBody CreatCartDto creatCart) {
        Optional<Product> product = productService.findById(creatCart.getProductHome().getId());
        Optional<Customer> customer = customerService.findByIdAccount(creatCart.getIdAccount());
        if (product.isPresent() && customer.isPresent()) {
            Cart cart = new Cart();
            BeanUtils.copyProperties(creatCart, cart);
            cart.setCustomer(customer.get());
            cart.setProduct(product.get());
            cartService.save(cart);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("user/cart/list-cart")
    public ResponseEntity<List<Cart>> getList(@RequestParam(defaultValue = "")String email) {
        boolean checkEmail = accountService.existsByEmail(email);
        if (checkEmail) {
            Optional<Account> account = accountService.findByEmail(email);
            if (account.isPresent()){
                List<Cart> cartList = cartService.findAllByIdAccount(account.get().getIdAccount());
                if (!cartList.isEmpty()) {
                    return new ResponseEntity<>(cartList, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
