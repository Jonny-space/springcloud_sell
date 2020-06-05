package com.springcloud.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.common.result.BaseResult;
import com.springcloud.common.result.ResultVO;
import com.springcloud.order.common.entries.OrderMaster;
import com.springcloud.order.mapper.OrderMasterMapper;
import com.springcloud.order.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
@Service
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements OrderMasterService {

    @Autowired
    private OrderMasterMapper masterMapper;

    @Override
    public List<OrderMaster> getAll() {
        return masterMapper.selectList(new QueryWrapper<>(new OrderMaster()));
    }
}
