package com.demo.storageservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "IAM-SERVICE")
public interface IamClient {

    @GetMapping("/test/iam")
    String helloFromIam();
}