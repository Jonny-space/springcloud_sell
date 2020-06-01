package com.springcloud.order.web;


import com.springcloud.order.entity.OrderDetail;
import com.springcloud.order.entity.OrderMaster;
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
public class OrderMasterController {

    @Autowired
    private OrderMasterService orderMasterService;


    @GetMapping("/infos")
    public List<OrderMaster> info(){
        return orderMasterService.getAll();
    }
}

