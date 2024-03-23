package com.example.firstspringapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private  Long id;
    private String description;
    private String name;
    private String imageUrl;
    private Category category;
    private double price;
}
