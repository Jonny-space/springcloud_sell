package com.springcloud.order.service;

import com.springcloud.order.common.entries.OrderDetail;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
public interface OrderDetailService extends IService<OrderDetail> {

    List<OrderDetail> getAll();

}
