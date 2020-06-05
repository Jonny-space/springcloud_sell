package com.springcloud.order.web;


import com.springcloud.common.result.BaseResult;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.entries.OrderMaster;
import com.springcloud.order.common.service.OrderMasterInterface;
import com.springcloud.order.service.OrderDetailService;
import com.springcloud.order.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/orderMaster")
public class OrderMasterController implements OrderMasterInterface {

    @Autowired
    private OrderMasterService orderMasterService;

    @Override
    public List<OrderMaster> infos() {
        return orderMasterService.getAll();
    }
}

