package com.springcloud.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.common.result.BaseResult;
import com.springcloud.common.result.ResultVO;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.mapper.OrderDetailMapper;
import com.springcloud.order.service.OrderDetailService;
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
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
    @Autowired
    private OrderDetailMapper mapper;

    @Override
    public List<OrderDetail> getAll() {
        Wrapper<OrderDetail> wrapper = new QueryWrapper<>(new OrderDetail());
        return mapper.selectList(wrapper);
    }
}
