package com.springcloud.orderconsumer.service;

import com.springcloud.order.common.service.OrderMasterInterface;
import com.springcloud.orderconsumer.service.impl.HelloFeginFailBackImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 17:27 2020/6/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name = "order-provider")
public interface OrderMasterFeignInterface extends OrderMasterInterface {
}
