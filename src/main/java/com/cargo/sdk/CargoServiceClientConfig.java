package com.cargo.sdk;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargoServiceClientConfig {

    @Bean
    public CargoServiceClient cargoServiceClient(FeignClientBuilder feignClientBuilder) {
        return feignClientBuilder.forType(CargoServiceClient.class,"cargo")
                .url("http://localhost:8080/v1/api/delivery")
                .build();
    }
}
