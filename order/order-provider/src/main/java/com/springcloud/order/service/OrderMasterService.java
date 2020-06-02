package com.springcloud.order.service;

import com.springcloud.order.common.entries.OrderMaster;
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
public interface OrderMasterService extends IService<OrderMaster> {

    List<OrderMaster> getAll();
}
