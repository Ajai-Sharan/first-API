package com.example.cartservicesstexam.Controllers;

import com.example.cartservicesstexam.Models.CartProduct;
import com.example.cartservicesstexam.Services.CartProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartProductController {
    private CartProductServices cartProductServices;
    public CartProductController(CartProductServices cartProductServices){
        this.cartProductServices = cartProductServices;
    }

    @GetMapping("/carts/products")
    public List<CartProduct> getAllCartProduct(){

        return cartProductServices.getAllCartProduct();
    }


}
