package com.example.firstspringapi.controllers;

import com.example.firstspringapi.exceptions.ProductNotFoundException;
import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

 // this controller is going to host rest http api's

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    //@Autowired // in the latest version spring it is not mandatory not required
    ProductController(@Qualifier("selfProductServiceImpl") ProductService ps){
        this.productService = ps;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ProductNotFoundException{
        Product productHttpEntity = productService.getProductById(id);
        if(productHttpEntity == null){
            throw new ProductNotFoundException(" ");
        }
        return new ResponseEntity<>(productHttpEntity,HttpStatus.OK);
       // throw new RuntimeException("sedfedf");
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    // to make it as generic we use product object instead of fakestoreproduct
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);
    }

    // create product
    //update product - partial update (PATCH)
    // replace product
    // delete product
}
