package com.springcloud.common.utils.serializ;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:41 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

public class DateToLong implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if(object instanceof Date){
            SerializeWriter out = serializer.out;
            long time=((Date) object).getTime();
            out.writeLong(time);
        }
    }
}

