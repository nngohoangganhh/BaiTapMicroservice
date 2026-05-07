package com.demo.iamservice.controller;

import com.demo.commonlib.response.ApiResponse;import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/iam")
    public String test() {
        System.out.println("ĐÃ VÀO /test/iam");
        return "HELLO IAM";
    }
    @GetMapping("/test/hello-call")
    public ApiResponse <String> helloCall( Authentication authentication) {
              return ApiResponse.<String>builder()
                      .success(true)
                      .massage("call thành công")
                      .data(authentication.getName())
                      .build();
    }
    @GetMapping("/test/iam/me")
    public String me() {
        System.out.println("123455");
        return "Hello " ;
    }
}