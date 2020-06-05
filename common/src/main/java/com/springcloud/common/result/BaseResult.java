package com.springcloud.common.result;

import com.springcloud.common.enums.ResultEnums;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:38 2020/6/4
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class BaseResult implements Serializable {


    private int code;
    private Object data;
    private String message;
    private Cursor cursor;
    private List<Error> errors;

    // TODO 返回无参ok
    public static BaseResult ok(){
        return createRestult(ResultEnums.SUCCESS, null,null  ) ;
    }

    // TODO 返回带success 的 ok
    public static BaseResult ok(String success){
        return createRestult(ResultEnums.SUCCESS, null, null);
    }

    // TODO 返回带 data 的ok
    public static BaseResult ok(Object data){
        return createRestult(ResultEnums.SUCCESS, data, null);
    }

    // 返回带分页的数据
    public static BaseResult ok(Object data, Cursor cursor) {
        return createRestult(ResultEnums.SUCCESS, data, cursor);
    }


    // TODO 返回错误数据
    public static BaseResult notOk(ResultEnums resultEnums){
        return createRestult(resultEnums, null, null);
    }


    // TODO 构建错误与正确方法
    public static BaseResult createRestult(ResultEnums result, Object data, Cursor cursor){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(result.getCode());
        baseResult.setData(data);
        baseResult.setMessage(result.getMessage());
        baseResult.setCursor(cursor);
        return baseResult;
    }


    @Data
    @AllArgsConstructor
    public static class Cursor {
        private int total;
        private int offset;
        private int limit;
    }
}
