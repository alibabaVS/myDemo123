package com.example.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PackageName:com.example.configclient
 * ClassName: TestController
 *
 * @author zha.jiangjiang
 * @Description:
 * @Date: 2018/10/7 23:42
 * @see
 * @since JDK 1.8
 */
@RefreshScope
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Value("${from}")
    private String from;

    @Resource
    private Environment environment;

    @RequestMapping("/from")
    public String from(){
        logger.info("op=start_from, >>>>>>>>>>>>>>>>>");

        return this.from;
    }

    @RequestMapping("/from1")
    public String from1(){
        return environment.getProperty("from");

    }
}
