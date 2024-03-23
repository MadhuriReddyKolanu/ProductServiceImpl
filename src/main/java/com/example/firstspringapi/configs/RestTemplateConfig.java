package com.example.firstspringapi.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // spring will keep ready to go through this class and to create and return all type of configurations
// can also use @Component
public class RestTemplateConfig {
    @Bean // it will create an object store it inside the container and return that object here
    public RestTemplate getRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
