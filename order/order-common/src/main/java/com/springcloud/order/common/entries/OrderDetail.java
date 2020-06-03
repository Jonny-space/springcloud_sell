package com.springcloud.order.common.entries;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
