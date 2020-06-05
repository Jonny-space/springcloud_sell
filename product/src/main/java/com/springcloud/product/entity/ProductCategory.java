package com.springcloud.product.entity;

import java.util.Date;
import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("product_category")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;
    /**
     * ç±»ç›®åå­—
     */
    @TableField("category_name")
    private String categoryName;
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
