package com.ccolanjo.cart.controller;

import com.ccolanjo.cart.entity.Cart;
import com.ccolanjo.cart.entity.Product;
import com.ccolanjo.cart.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private CartRepository cartRepository;
    private static final Logger log = LoggerFactory.getLogger(CartController.class);
    public CartController(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @GetMapping("/carts")
    List<Cart> getAllItems(){
        return cartRepository.findAll();
    }

    @PostMapping("/carts")
    Cart addItemCart(@RequestBody Product product){
        Cart cart = new Cart(product.getId(), product.getDescription());
        return cartRepository.save(cart);
    }

    @DeleteMapping("/carts/{id}")
    void deleteItemCart(@PathVariable Long id){
        cartRepository.deleteById(id);
    }
}
