package com.example.firstspringapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// to exactly match the output of fakestore api because category was different class itself but here it is string
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String descripton;
    private String category;
    private double price;
    private String imageUrl;
}
