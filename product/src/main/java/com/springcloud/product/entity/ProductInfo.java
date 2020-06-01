package com.springcloud.product.entity;

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
@TableName("product_info")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("product_id")
    private String productId;
    /**
     * å•†å“åç§°
     */
    @TableField("product_name")
    private String productName;
    /**
     * å•ä»·
     */
    @TableField("product_price")
    private BigDecimal productPrice;
    /**
     * åº“å­˜
     */
    @TableField("product_stock")
    private Integer productStock;
    /**
     * æè¿°
     */
    @TableField("product_description")
    private String productDescription;
    /**
     * å°å›¾
     */
    @TableField("product_icon")
    private String productIcon;
    /**
     * å•†å“çŠ¶æ€,0æ­£å¸¸1ä¸‹æž¶
     */
    @TableField("product_status")
    private Integer productStatus;
    /**
     * ç±»ç›®ç¼–å·
     */
    @TableField("category_type")
    private Integer categoryType;
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
