package com.example.feignconsumer;

import com.example.helloserviceapi.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Hello-service",fallback = HelloServiceFallback.class)
public interface RefactorHelloService extends HelloService {

}
