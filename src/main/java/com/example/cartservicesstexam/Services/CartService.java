package com.example.cartservicesstexam.Services;

import com.example.cartservicesstexam.Models.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getCarts();

    Cart getCartsById(Long id);

    List<Cart> getUserCarts(Long id);

    Cart addNewCart(Cart cart);

    void updateCart(Long id, Cart cart);

    void deleteCart(Long id);



}
