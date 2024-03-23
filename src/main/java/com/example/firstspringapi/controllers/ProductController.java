package com.example.firstspringapi.controllers;

import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

 // this controller is going to host rest http api's

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    //@Autowired // in the latest version spring it is not mandatory not required
    ProductController(ProductService ps){
        this.productService = ps;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // create product
    //update product - partial update (PATCH)
    // replace product
    // delete product
}
