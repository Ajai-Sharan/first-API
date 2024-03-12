package com.example.cartservicesstexam.dtos;

import com.example.cartservicesstexam.Models.CartProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class FakeStoreCartDto {
    private long id;

    private long userId;

    private String date;

    private List<CartProduct> cartproducts;
}
