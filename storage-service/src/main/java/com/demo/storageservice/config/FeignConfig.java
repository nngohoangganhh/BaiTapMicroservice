package com.demo.storageservice.config;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            ServletRequestAttributes attributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes == null) {
                return;
            }
                HttpServletRequest request = attributes.getRequest();

                String token = request.getHeader("Authorization");

                System.out.println("có gì nào :" + token);
                if (token != null && token.startsWith("Bearer ")) {
                    System.out.println("có gì trong này nhỉ ");
                    template.header("Authorization", token);
                }
        };
    }
}