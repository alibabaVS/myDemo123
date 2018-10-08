package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//@RefreshScope
@RestController
public class TestController {
    @Value("${from")
    private String from;

    @RequestMapping("/from")
    public String from(){
        return this.from;
    }
}
