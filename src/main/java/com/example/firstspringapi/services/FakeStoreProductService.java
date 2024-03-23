package com.example.firstspringapi.services;

import com.example.firstspringapi.dtos.FakeStoreProductDto;
import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service // create an object of this class at the time of initialization
public class FakeStoreProductService  implements  ProductService{

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate rt){
        this.restTemplate = rt;
    }

    private Product convertfakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescripton());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(Long id) {
       // RestTemplate restTemplate = new RestTemplate(); can we create a bean of it in psring container and can reuse it it
        FakeStoreProductDto fakeStoreProductDto =  restTemplate.
                getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
        if(fakeStoreProductDto == null)
            return null;
        return convertfakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
