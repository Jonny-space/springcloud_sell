package com.springcloud.order.common.client;

import com.springcloud.common.dto.CartDTO;
import com.springcloud.common.result.BaseResult;
import com.springcloud.order.common.entries.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:58 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@FeignClient(
        name="product-provider",
        fallback = ProductClient.ProductClientFallback.class
)
public interface  ProductClient {
    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<Long> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

    @Component
    public static class ProductClientFallback implements ProductClient{

        @Override
        public String productMsg() {
            return null;
        }

        @Override
        public List<ProductInfo> listForOrder(List<Long> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<CartDTO> cartDTOList) {

        }
    }
}
