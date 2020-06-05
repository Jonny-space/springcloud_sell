package com.springcloud.order.common.dto;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springcloud.common.utils.EnumUtil;
import com.springcloud.common.utils.serializ.DateToLong;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.common.enums.OrderStatusEnums;
import com.springcloud.common.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:29 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class OrderDTO {
    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @JSONField(serializeUsing = DateToLong.class)
    private Date createTime;

    @JSONField(serializeUsing = DateToLong.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnums getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnums.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
