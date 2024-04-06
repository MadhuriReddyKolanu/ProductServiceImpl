package com.example.firstspringapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String description;
    private String name;
    private String imageUrl;
    @ManyToOne
    private Category category;
    private double price;
}
