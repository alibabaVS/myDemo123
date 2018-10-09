package com.example.helloserviceapi;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("refactor")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello2")
//    那么需要在请求参数前加上@RequestParam注解修饰，Controller里面可以不加该注解修饰。
//    feign中你可以有多个@RequestParam，但只能有不超过一个@RequestBody。
//    feign中绑定参数必须通过value属性来指明具体的参数名，不然会抛出IllegalStateExcepton异常
    User hello(@RequestParam("name")String name,@RequestParam("age") Integer age);
}
