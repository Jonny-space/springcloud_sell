package com.springcloud.orderconsumer.controller;

import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.entries.OrderMaster;
import com.springcloud.order.common.service.OrderDetailInterface;
import com.springcloud.orderconsumer.service.OrderDetailFeignInterface;
import com.springcloud.orderconsumer.service.OrderMasterFeignInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 14:09 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RestController
@RequestMapping("/api/order")
public class OrderDetailController {
    @Resource
    private OrderDetailFeignInterface detailFeignInterface;
    @Resource
    private OrderMasterFeignInterface masterFeignInterface;

    @RequestMapping("/detail/infos")
    public List<OrderDetail> infos() {
        return detailFeignInterface.infos();
    }

    @RequestMapping("/master/infos")
    public List<OrderMaster> msinfos() {
        return masterFeignInterface.infos();
    }


}
