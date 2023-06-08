package com.backend.controller;

import com.backend.dto.cart.CartList;
import com.backend.dto.cart.CartTotal;
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
@RequestMapping("api/user/cart")
public class CartController {
    @Autowired
    ICartService cartService;
    @Autowired
    IProductService productService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IAccountService accountService;

    @PostMapping("add-product-to-cart")
    public ResponseEntity<Cart> addProductToCart(@RequestBody CreatCartDto creatCart) {
        try {
            Optional<Product> product = productService.findById(creatCart.getProductHome().getId());
            Optional<Customer> customer = customerService.findById(creatCart.getIdCustomer());
            if (product.isPresent() && customer.isPresent()) {
                Optional<Cart> cart = cartService.findByProductAndCustomer(product.get(), customer.get());
                if (cart.isPresent()) {
                    Cart cartOld = cart.get();
                    cartOld.setNumberOfProduct(cartOld.getNumberOfProduct() + creatCart.getNumberOfProduct());
                    cartService.save(cartOld);
                    return new ResponseEntity<>(cartOld, HttpStatus.OK);
                } else {
                    Cart cartNew = new Cart();
                    BeanUtils.copyProperties(creatCart, cartNew);
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
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("list-cart")
    public ResponseEntity<List<CartList>> getList(@RequestParam(defaultValue = "") int idCustomer) {
        Optional<Customer> customerOptional = customerService.findById(idCustomer);
        if (customerOptional.isPresent()) {
            List<CartList> cartList = cartService.findAllByCustomer(customerOptional.get());
            if (!cartList.isEmpty()) {
                return new ResponseEntity<>(cartList, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Cart> removeCart(@PathVariable("id") int id) {
        Optional<Cart> cart = cartService.findById(id);
        if (cart.isPresent()) {
            cartService.removeById(id);
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("get-total")
    public ResponseEntity<CartTotal> getTotal(@RequestParam(defaultValue = "") int idCustomer) {
        Optional<Customer> customerOptional = customerService.findById(idCustomer);
        if (customerOptional.isPresent()) {
            Optional<CartTotal> cartTotal = cartService.getTotal(customerOptional.get());
            if (cartTotal.isPresent()) {
                return new ResponseEntity<>(cartTotal.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("update-amount-product")
    public ResponseEntity<Cart> updateAmountOfProduct(@RequestBody CreatCartDto cart) {
        Optional<Cart> cartOptional = cartService.findById(cart.getId());
        if (cartOptional.isPresent()) {
            if (cart.getNumberOfProduct() > 0 && cart.getNumberOfProduct() <= 100) {
                cartOptional.get().setNumberOfProduct(cart.getNumberOfProduct());
                cartService.save(cartOptional.get());
                return new ResponseEntity<>(cartOptional.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}