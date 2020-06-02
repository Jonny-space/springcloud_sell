package com.springcloud.orderconsumer.service.impl;

import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.orderconsumer.service.OrderDetailFeignInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 15:26 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
//@Component
public class HelloFeginFailBackImpl implements OrderDetailFeignInterface {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<OrderDetail> infos() {
        logger.info("熔断，默认回调函数");
        return new ArrayList<>();
    }
}
