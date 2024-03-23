package com.example.firstspringapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String descripton;
    private String category;
    private double price;
    private String imageUrl;
}
