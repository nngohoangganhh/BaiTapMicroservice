package com.demo.storageservice.controller;


import com.demo.storageservice.client.IamClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/storage")
@RequiredArgsConstructor
public class StorageTestController {

    private final IamClient iamClient;

    @GetMapping("/call-iam")
    public String callIam() {
        return "Storage gọi IAM: " + iamClient.helloFromIam();
    }
}