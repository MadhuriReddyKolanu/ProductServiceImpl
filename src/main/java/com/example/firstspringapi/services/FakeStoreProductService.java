package com.example.firstspringapi.services;

import com.example.firstspringapi.dtos.FakeStoreProductDto;
import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService") // create an object of this class at the time of initialization
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
        int x = 1 / 0;
       // RestTemplate restTemplate = new RestTemplate(); can we create a bean of it in psring container and
        // can reuse it it
        FakeStoreProductDto fakeStoreProductDto =  restTemplate.
                getForObject("https://fakestoreapi.com/products/" + x,
                        FakeStoreProductDto.class);
        if(fakeStoreProductDto == null)
            return null;
        return convertfakeStoreDtoToProduct(fakeStoreProductDto);
        //throw new RuntimeException("something went wrong");
    }

    @Override
    public List<Product> getAllProducts() {
        //AT RUNTIME CONVERT THIS API RESP[O[NSE TO LIST<FakeStoreProductDto>
       // List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products/",
         //       List.class);
        // if we need data type of something at run time
        // arrays dont use generics in impl
        //if we create List<String> then at run time it will be List<String>
        FakeStoreProductDto[] fakeStoreProductDtos =restTemplate.getForObject("https://fakestoreapi.com/products/",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertfakeStoreDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(product.getName());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT,
                requestCallback, responseExtractor );

        return convertfakeStoreDtoToProduct(fakeStoreProductDto);
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
    //get all categories
    // get in category

}
