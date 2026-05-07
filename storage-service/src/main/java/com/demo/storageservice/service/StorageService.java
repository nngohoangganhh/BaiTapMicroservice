package com.demo.storageservice.service;


import com.demo.storageservice.client.IamClient;
import com.demo.storageservice.config.FeignConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class StorageService {

    private final IamClient iamClient;

    @Retry(name = "iamService", fallbackMethod = "fallbackCallIam")
    @CircuitBreaker(name = "iamService", fallbackMethod = "fallbackCallIam")
    public String callIam() {
        return  iamClient.helloFromIam();
    }

    public String fallbackCallIam(Throwable t) {
        return "IAM service đang lỗi, fallback từ storage-service";
    }
}