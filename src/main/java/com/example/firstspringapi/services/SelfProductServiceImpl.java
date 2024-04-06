package com.example.firstspringapi.services;

import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

// this is another way to give bean name within brackets of service annotation
// and use the one which is required in controller as @Qualifier - this is another way
@Service("selfProductServiceImpl")
// this should be injected if there are more than one service impl - this is one way
//@Primary
public class SelfProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        //fetch the product with given id from dtaabase
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
