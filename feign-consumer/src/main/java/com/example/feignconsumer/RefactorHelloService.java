package com.example.feignconsumer;

import com.example.helloserviceapi.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Hello-service")
public interface RefactorHelloService extends HelloService {

}
