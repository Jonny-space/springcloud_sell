package com.springcloud.order.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("detail_id")
    private String detailId;
    @TableField("order_id")
    private String orderId;
    @TableField("product_id")
    private String productId;
    /**
     * å•†å“åç§°
     */
    @TableField("product_name")
    private String productName;
    /**
     * å½“å‰ä»·æ ¼,å•ä½åˆ†
     */
    @TableField("product_price")
    private BigDecimal productPrice;
    /**
     * æ•°é‡
     */
    @TableField("product_quantity")
    private Integer productQuantity;
    /**
     * å°å›¾
     */
    @TableField("product_icon")
    private String productIcon;
    /**
     * åˆ›å»ºæ—¶é—´
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * ä¿®æ”¹æ—¶é—´
     */
    @TableField("update_time")
    private Date updateTime;


}
