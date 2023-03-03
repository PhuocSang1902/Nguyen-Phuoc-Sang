package com.backend.controller;

import com.backend.dto.cart.CartList;
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
            Optional<Cart> cart = cartService.findByProductAndCustomer(product.get(), customer.get());
            if (cart.isPresent()){
                Cart cartOld = cart.get();
                cartOld.setNumberOfProduct(cartOld.getNumberOfProduct() + creatCart.getNumberOfProduct());
                cartService.save(cartOld);
                return new ResponseEntity<>(cartOld, HttpStatus.OK);
            }else {
                Cart cartNew = new Cart();
                BeanUtils.copyProperties(creatCart, cart);
                cartNew.setCustomer(customer.get());
                cartNew.setProduct(product.get());
                if (cartNew.getNumberOfProduct() <= 0) {
                    cartNew.setNumberOfProduct(1);
                }
                cartService.save(cartNew);
                return new ResponseEntity<>(cartNew, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("user/cart/list-cart")
    public ResponseEntity<List<CartList>> getList(@RequestParam(defaultValue = "") String email) {
        boolean checkEmail = accountService.existsByEmail(email);
        if (checkEmail) {
            Optional<Account> account = accountService.findByEmail(email);
            if (account.isPresent()) {
                List<CartList> cartList = cartService.findAllByIdAccount(account.get().getIdAccount());
                if (!cartList.isEmpty()) {
                    return new ResponseEntity<>(cartList, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("user/cart/delete/{id}")
    public ResponseEntity<Cart> removeCart(@PathVariable("id") int id) {
        Optional<Cart> cart = cartService.findById(id);
        if (cart.isPresent()) {
            cartService.removeById(id);
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
