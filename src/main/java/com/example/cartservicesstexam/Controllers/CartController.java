package com.example.cartservicesstexam.Controllers;

import com.example.cartservicesstexam.Models.Cart;
import com.example.cartservicesstexam.Services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public List<Cart> getCarts(){

        return cartService.getCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getCartsById(@PathVariable Long id){

        return cartService.getCartsById(id);
    }

    @GetMapping("/carts/user/{id}")
    public List<Cart> getUserCarts(@PathVariable Long id){
        return cartService.getUserCarts(id);
    }

    @PostMapping("/carts")
    public Cart addNewCart(@RequestBody Cart cart){

        return cartService.addNewCart(cart);
    }

    @PutMapping("/carts/{id}")
    public void updateCart(@PathVariable Long id, @RequestBody Cart cart){
        cartService.updateCart(id, cart);
    }

    @DeleteMapping("/carts/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
    }



}
