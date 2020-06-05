package com.springcloud.common.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 9:51 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public enum OrderStatusEnums implements IEnum<Integer> {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;
    private int value;
    private String desc;

    OrderStatusEnums(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
