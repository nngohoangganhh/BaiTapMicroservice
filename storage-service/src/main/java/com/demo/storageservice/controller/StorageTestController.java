package com.demo.storageservice.controller;

import com.demo.commonlib.response.ApiResponse;
import com.demo.storageservice.client.IamClient;
import com.demo.storageservice.service.StorageService;
import jakarta.ws.rs.GET;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StorageTestController {

    private final IamClient iamClient;
    private final StorageService storageService;

    public StorageTestController(IamClient iamClient, StorageService storageService ) {
        this.iamClient = iamClient;
        this.storageService = storageService;
    }

    @GetMapping("/call-iam")
    public ApiResponse<String> callIam() {
        return com.demo.commonlib.response.ApiResponse.<String>builder()
                .success(true)
                .massage("call iam  thành công ")
                .data(storageService.callIam())
                .build();
    }

    @GetMapping("/hello")
    public ApiResponse<String> hello() {
        return ApiResponse.<String>builder()
                .success(true)
                .massage("test hello")
                .data(iamClient.helloFromIam())
                .build();
    }

}