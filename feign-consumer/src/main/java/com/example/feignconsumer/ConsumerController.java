package com.example.feignconsumer;

import com.example.helloserviceapi.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PackageName:com.example.feignconsumer
 * ClassName: ConsumerController
 *
 * @author zha.jiangjiang
 * @Description:
 * @Date: 2018/9/27 0:44
 * @see
 * @since JDK 1.8
 */
@RestController
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Resource
    HelloService helloService;

    @Resource
    RefactorHelloService refactorHelloService;

    @RequestMapping("/feign-consumer")
    public String helloConsumer(){
        String str = helloService.hello();
        logger.info("op=start_helloConsumer,>>>>>>>>>>>>>>>>>>>>>>> " );
        User str2 = refactorHelloService.hello("name",13);
        logger.info("op=start_helloConsumer, {}",str2 );
        return str;
    }
}
