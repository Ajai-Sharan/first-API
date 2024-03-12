package com.example.cartservicesstexam.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {
    private long id;

    private long userId;

    private String date;

    private List<CartProduct> cartproducts;

}
