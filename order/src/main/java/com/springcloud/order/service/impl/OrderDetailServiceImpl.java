package com.springcloud.order.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.springcloud.order.entity.OrderDetail;
import com.springcloud.order.mapper.OrderDetailMapper;
import com.springcloud.order.service.OrderDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
        Wrapper<OrderDetail> wrapper = new Condition();
        return mapper.selectList(wrapper);
    }
}
