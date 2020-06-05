package com.springcloud.orderconsumer.service.impl;

import com.springcloud.common.result.BaseResult;
import com.springcloud.common.enums.ResultEnums;
import com.springcloud.common.result.ResultVO;
import com.springcloud.order.common.VO.OrderRequestVo;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.form.OrderForm;
import com.springcloud.orderconsumer.service.OrderDetailFeignInterface;
import feign.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 15:26 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Component
public class OrderDetailFeginFailBackImpl implements OrderDetailFeignInterface {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<OrderDetail> infos() {
        logger.info("熔断，默认回调函数");
        return new ArrayList<>();
    }

    @Override
    public Map<String,String> create(OrderForm orderForm) {
        return new HashMap<>();
    }

}
