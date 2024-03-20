package com.example.doan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartIterm {
    private Long productid;
    private String name;
    private String img;
    private  double price;
    private double quantity = 1;
}

