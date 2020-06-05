package com.springcloud.order.common.entries;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.*;
import com.springcloud.common.enums.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * <p>
 * 
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_master")
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id",type = IdType.ID_WORKER)
    private long orderId;
    /**
     * ä¹°å®¶åå­—
     */
    @TableField("buyer_name")
    private String buyerName;
    /**
     * ä¹°å®¶ç”µè¯
     */
    @TableField("buyer_phone")
    private String buyerPhone;
    /**
     * ä¹°å®¶åœ°å€
     */
    @TableField("buyer_address")
    private String buyerAddress;
    /**
     * ä¹°å®¶å¾®ä¿¡openid
     */
    @TableField("buyer_openid")
    private String buyerOpenid;
    /**
     * è®¢å•æ€»é‡‘é¢
     */
    @TableField("order_amount")
    private BigDecimal orderAmount;
    /**
     * è®¢å•çŠ¶æ€, é»˜è®¤ä¸ºæ–°ä¸‹å•
     */
    @TableField("order_status")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private OrderStatusEnums orderStatus = OrderStatusEnums.NEW;
    /**
     * æ”¯ä»˜çŠ¶æ€, é»˜è®¤æœªæ”¯ä»˜
     */
    @TableField("pay_status")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private PayStatusEnum payStatus = PayStatusEnum.WAIT;
    /**
     * åˆ›å»ºæ—¶é—´
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * ä¿®æ”¹æ—¶é—´
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
