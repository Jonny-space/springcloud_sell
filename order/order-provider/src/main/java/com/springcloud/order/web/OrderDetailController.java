package com.springcloud.order.web;


import com.baomidou.mybatisplus.extension.api.R;
import com.springcloud.common.result.BaseResult;
import com.springcloud.common.enums.ResultEnums;
import com.springcloud.common.result.ResultVO;
import com.springcloud.order.common.VO.OrderRequestVo;
import com.springcloud.order.common.convert.OrderForm2OrderDTOConverter;
import com.springcloud.order.common.dto.OrderDTO;
import com.springcloud.common.exception.SellException;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.form.OrderForm;
import com.springcloud.order.common.service.OrderDetailInterface;
import com.springcloud.order.service.OrderDetailService;
import com.springcloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
@RestController
@Slf4j
public class OrderDetailController implements OrderDetailInterface {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @Override
    public List<OrderDetail> infos() {

        return orderDetailService.getAll();
    }

    @Override
    public Map<String,String> create(@RequestBody @Valid OrderForm orderForm) {

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnums.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderId",createResult.getOrderId());
        return map;

    }
}

