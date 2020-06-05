package com.springcloud.orderconsumer.controller;

import com.springcloud.common.enums.ResultEnums;
import com.springcloud.common.exception.SellException;
import com.springcloud.common.result.BaseResult;
import com.springcloud.order.common.VO.OrderRequestVo;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.entries.OrderMaster;
import com.springcloud.order.common.form.OrderForm;
import com.springcloud.order.common.service.OrderDetailInterface;
import com.springcloud.orderconsumer.service.OrderDetailFeignInterface;
import com.springcloud.orderconsumer.service.OrderMasterFeignInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 14:09 2020/6/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderDetailController {
    @Resource
    private OrderDetailFeignInterface detailFeignInterface;
    @Resource
    private OrderMasterFeignInterface masterFeignInterface;

    @RequestMapping("/detail/infos")
    public BaseResult infos() {

        return BaseResult.ok(detailFeignInterface.infos());
    }

    @RequestMapping("/master/infos")
    public BaseResult msinfos() {
        return BaseResult.ok(masterFeignInterface.infos());
    }

    @PostMapping("/create")
    public BaseResult create(@RequestBody @Valid OrderForm orderForm , BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(), ResultEnums.PARAM_ERROR);
        }
        return BaseResult.ok(detailFeignInterface.create(orderForm));
    }
}
