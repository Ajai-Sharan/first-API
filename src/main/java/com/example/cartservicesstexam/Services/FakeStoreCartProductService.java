package com.example.cartservicesstexam.Services;

import com.example.cartservicesstexam.Models.CartProduct;
import com.example.cartservicesstexam.dtos.FakeStoreCartDto;
import com.example.cartservicesstexam.dtos.FakeStoreCartProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCartProductService implements CartProductServices{
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com/carts/products";


    @Override
    public List<CartProduct> getAllCartProduct() {
        FakeStoreCartProductDto[] fakeStoreCartProduct = restTemplate.getForObject(
                url, FakeStoreCartProductDto[].class
        );

        if(fakeStoreCartProduct != null){
            List<CartProduct> cartProducts = new ArrayList<>();

            for(FakeStoreCartProductDto cartproduct : fakeStoreCartProduct){
                CartProduct cartProduct1 = new CartProduct();
                cartProduct1.setProductId(cartproduct.getProductId());
                cartProduct1.setQuantity(cartProduct1.getQuantity());
                cartProducts.add(cartProduct1);
            }

            return cartProducts;
        }

        return null;
    }
}
