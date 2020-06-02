package com.springcloud.orderconsumer.service;

import com.springcloud.order.common.service.OrderDetailInterface;
import com.springcloud.orderconsumer.service.impl.HelloFeginFailBackImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 14:10 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name = "order-provider")
public interface OrderDetailFeignInterface extends OrderDetailInterface {
}
