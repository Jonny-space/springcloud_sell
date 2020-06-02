package com.springcloud.order.web;


import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.service.OrderDetailInterface;
import com.springcloud.order.service.OrderDetailService;
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
public class OrderDetailController implements OrderDetailInterface {

    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    public List<OrderDetail> infos() {
        return orderDetailService.getAll();
    }
}

