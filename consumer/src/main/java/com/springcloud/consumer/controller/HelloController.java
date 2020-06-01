package com.springcloud.consumer.controller;

import com.springcloud.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 14:09 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RestController
public class HelloController {
    @Autowired
    HelloService  helloService;
    @RequestMapping("say")
    public String say(@RequestParam("name") String name){
        return helloService.hello(name);
    }

}
