package com.springcloud.order.common.service;

import com.springcloud.common.result.BaseResult;
import com.springcloud.common.result.ResultVO;
import com.springcloud.order.common.VO.OrderRequestVo;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.form.OrderForm;
import feign.Param;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 17:14 2020/6/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface OrderDetailInterface {
    @GetMapping("/order/infos")
    List<OrderDetail> infos();

    @PostMapping("/order/create")
    Map<String,String> create(@RequestBody @Valid OrderForm orderForm);

}
