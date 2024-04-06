package com.example.firstspringapi.services;

import com.example.firstspringapi.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct();
}
