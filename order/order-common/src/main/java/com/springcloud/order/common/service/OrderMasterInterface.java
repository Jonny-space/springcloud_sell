package com.springcloud.order.common.service;

import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.entries.OrderMaster;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 17:26 2020/6/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface OrderMasterInterface {
    @GetMapping("/api/ordermaster/infos")
    List<OrderMaster> infos();
}
