package com.midas.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/sayHelloPublic")
    public String sayHello(){
        return "Hello Rodrigo!";
    }

    @GetMapping("/sayHelloProtected")
    public String sayHelloProtected(){
        return "Hello Rodrigo con proteccion!";
    }
}
