package com.demo.storageservice.client;

import com.demo.storageservice.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "IAM-SERVICE", configuration = FeignConfig.class)
public interface IamClient {

    @GetMapping("/test/iam")
    String helloFromIam();

    @GetMapping("/test/hello-call")
    String callFromIam();

    @GetMapping("/api/iam/me")
    String me();
}