package com.springcloud.common.dto;

import lombok.Data;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:53 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class CartDTO {
    /** 商品Id. */
    private long productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(){

    }

    public CartDTO(long productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
