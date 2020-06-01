package com.springcloud.consumer.service.impl;

import com.springcloud.consumer.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 15:26 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Component
public class HelloFeginFailBackImpl implements HelloService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String hello(String name) {
        logger.info("熔断，默认回调函数");
        return "{\"id\":-1,\"name\":\"熔断用户\",\"msg\":\"请求异常，返回熔断用户！\"}";
    }
}
