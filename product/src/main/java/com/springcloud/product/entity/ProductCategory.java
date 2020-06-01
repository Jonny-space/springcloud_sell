package com.springcloud.product.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
