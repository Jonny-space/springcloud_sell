package com.springcloud.order.common.VO;

import com.springcloud.order.common.form.OrderForm;
import lombok.Data;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 12:49 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Data
public class OrderRequestVo {
    private OrderForm orderForm;
    private BindingResult bindingResult;

}
