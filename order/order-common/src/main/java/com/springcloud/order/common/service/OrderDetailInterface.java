package com.springcloud.order.common.service;

import com.springcloud.order.common.entries.OrderDetail;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 17:14 2020/6/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface OrderDetailInterface {
    @GetMapping("/api/orderdetail/infos")
    List<OrderDetail> infos();
}
