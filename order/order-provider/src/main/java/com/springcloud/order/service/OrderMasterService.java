package com.springcloud.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.common.result.BaseResult;
import com.springcloud.common.result.ResultVO;
import com.springcloud.order.common.entries.OrderMaster;


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
