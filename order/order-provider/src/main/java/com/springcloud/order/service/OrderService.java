package com.springcloud.order.service;

import com.springcloud.order.common.dto.OrderDTO;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:46 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
}
