package com.springcloud.common.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 9:56 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public enum PayStatusEnum implements IEnum<Integer> {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public Integer getValue() {
        return this.code;
    }
}
