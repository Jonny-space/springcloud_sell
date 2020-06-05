package com.springcloud.common.utils;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:31 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class EnumUtil {
    public static <T extends IEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getValue())) {
                return each;
            }
        }
        return null;
    }
}
