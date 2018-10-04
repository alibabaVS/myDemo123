package com.example.feignconsumer;

import com.example.helloserviceapi.HelloService;
import com.example.helloserviceapi.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PackageName:com.example.feignconsumer
 * ClassName: HelloServiceFallback
 *
 * @author zha.jiangjiang
 * @Description:
 * @Date: 2018/10/4 14:51
 * @see
 * @since JDK 1.8
 */
@Component
@RequestMapping("/fallback")
//feign hystrix必须要在配置文件中开启 feign.hystrix.enabled=true
public class HelloServiceFallback implements RefactorHelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public User hello(@RequestParam("name") String name, @RequestParam Integer age) {
        return new User("nana",11);
    }

}
