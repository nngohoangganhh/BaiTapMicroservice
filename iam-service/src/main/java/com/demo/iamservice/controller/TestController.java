package com.demo.iamservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/iam")
    public String test(){
        return " HELLO IAM ";
    }
}
