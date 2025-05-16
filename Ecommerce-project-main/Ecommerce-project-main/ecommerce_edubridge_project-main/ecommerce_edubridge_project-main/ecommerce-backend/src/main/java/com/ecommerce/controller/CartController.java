package com.ecommerce.controller;

import com.ecommerce.entity.Cart;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public Cart createCart(@RequestParam String username) {
        return cartService.createCartForUser(username);
    }
    
    @PostMapping("/add")
    public Cart addToCart(@RequestParam String username,
                          @RequestParam Long productId,
                          @RequestParam int quantity) {
        return cartService.addToCart(username, productId, quantity);
    }

    @GetMapping("/{username}")
    public Cart getCart(@PathVariable String username) {
        return cartService.getCartByUsername(username);
    }

    @DeleteMapping("/remove/{itemId}")
    public String removeItem(@PathVariable Long itemId) {
        cartService.removeCartItem(itemId);
        return "Item removed";
    }
}
