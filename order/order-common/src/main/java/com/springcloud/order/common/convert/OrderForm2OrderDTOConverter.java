package com.springcloud.order.common.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springcloud.common.enums.ResultEnums;
import com.springcloud.order.common.dto.OrderDTO;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.common.exception.SellException;
import com.springcloud.order.common.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:42 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnums.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
