package com.example.controller;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
    @Autowired
    IProductService productService;


    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteProductInCart(@PathVariable("id") Long id, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
                cart.deleteProductInCart(product.get());
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
    @GetMapping("pay")
    public String payForCart(@SessionAttribute("cart")Cart cart, RedirectAttributes redirectAttributes){
        cart.pay();
        redirectAttributes.addFlashAttribute("mess", "Pay successfully");
        return "redirect:/shop";
    }
}
