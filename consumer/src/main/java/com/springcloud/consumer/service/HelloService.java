package com.springcloud.consumer.service;

import com.springcloud.consumer.service.impl.HelloFeginFailBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 14:10 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name = "provider1",fallback = HelloFeginFailBackImpl.class)
public interface HelloService {
    //地址为服务提供者对外暴露的地址
    @RequestMapping(value = "/api/hello/say")
    String hello(@RequestParam("name") String name);
}
