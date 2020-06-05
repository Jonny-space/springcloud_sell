package com.springcloud.product.common;

import lombok.Data;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 11:45 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
