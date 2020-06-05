package com.springcloud.common.exception;

import com.springcloud.common.enums.ResultEnums;
import lombok.Getter;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:17 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class SellException extends RuntimeException{
    @Getter
    private ResultEnums resultEnums;

    public SellException(ResultEnums resultEnums) {
        this.resultEnums = resultEnums;
    }

    public SellException(String message, ResultEnums resultEnums) {
        super(message);
        this.resultEnums = resultEnums;
    }

    public SellException(String message, Throwable cause, ResultEnums resultEnums) {
        super(message, cause);
        this.resultEnums = resultEnums;
    }

    public SellException(Throwable cause, ResultEnums resultEnums) {
        super(cause);
        this.resultEnums = resultEnums;
    }

    public SellException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ResultEnums resultEnums) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resultEnums = resultEnums;
    }
}
