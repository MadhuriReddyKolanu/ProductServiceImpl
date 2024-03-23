package com.example.firstspringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this controller will be containing http api's
@RestController
// localhost:8080/
// all the api's for /sample endpoint should come to this controller
@RequestMapping("/sample")
public class SpringController {
    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/sayBye")
    public String sayBye(){
        return "Bye Everyone";
    }
}
