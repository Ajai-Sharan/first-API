package com.example.cartservicesstexam.Services;

import com.example.cartservicesstexam.Models.Cart;
import com.example.cartservicesstexam.dtos.FakeStoreCartDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCartService implements CartService{

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com/";
    @Override
    public List<Cart> getCarts() {
        FakeStoreCartDto[] fakeStoreCartDtos = restTemplate.getForObject(
                url+"carts",
                FakeStoreCartDto[].class
        );

        if(fakeStoreCartDtos != null){
            List<Cart> carts = new ArrayList<>();
            for (FakeStoreCartDto fakeStoreCartDto : fakeStoreCartDtos){
                Cart cart = convertToCart(fakeStoreCartDto);
                carts.add(cart);
            }
            return carts;
        }

        return null;

    }

    private Cart convertToCart(FakeStoreCartDto fakeStoreCartDto){
        if(fakeStoreCartDto == null)        return null;

        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setDate(fakeStoreCartDto.getDate());
        cart.setCartproducts(fakeStoreCartDto.getCartproducts());
        cart.setUserId(fakeStoreCartDto.getUserId());
        return cart;
    }

    @Override
    public Cart getCartsById(Long id) {
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
                url+"carts/"+id,
                FakeStoreCartDto.class
        );

        return convertToCart(fakeStoreCartDto);
    }

    @Override
    public List<Cart> getUserCarts(Long id) {
        FakeStoreCartDto[] fakeStoreCartDtos = restTemplate.getForObject(
                url+"carts/user/"+id,
                FakeStoreCartDto[].class
        );

        if(fakeStoreCartDtos != null){
            List<Cart> carts = new ArrayList<>();

            for (FakeStoreCartDto fakeStoreCartDto : fakeStoreCartDtos){
                Cart cart = convertToCart(fakeStoreCartDto);
                carts.add(cart);
            }

            return carts;
        }

        return null;
    }

    private FakeStoreCartDto convertToFakeStoreCartDto(Cart cart){
        if(cart == null)        return null;

        FakeStoreCartDto fakeStoreCartDto = new FakeStoreCartDto();

        fakeStoreCartDto.setId(cart.getId());
        fakeStoreCartDto.setDate(cart.getDate());
        fakeStoreCartDto.setCartproducts(cart.getCartproducts());
        fakeStoreCartDto.setUserId(cart.getUserId());

        return fakeStoreCartDto;
    }


    @Override
    public Cart addNewCart(Cart cart) {
        FakeStoreCartDto fakeStoreCartDto  = convertToFakeStoreCartDto(cart);

        FakeStoreCartDto fakeStoreCartDtoOutput = restTemplate.postForObject(
                url+"carts",
                fakeStoreCartDto,
                FakeStoreCartDto.class
        );

        return convertToCart(fakeStoreCartDto);
    }

    @Override
    public void updateCart(Long id, Cart cart) {
        FakeStoreCartDto fakeStoreCartDto = convertToFakeStoreCartDto(cart);

        restTemplate.put(
                url+"carts/"+id,
                fakeStoreCartDto,
                FakeStoreCartDto.class
        );

    }

    @Override
    public void deleteCart(Long id) {
        restTemplate.delete(url+"/carts/"+id);
    }
}
