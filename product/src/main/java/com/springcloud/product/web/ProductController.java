package com.springcloud.product.web;


import com.springcloud.common.dto.CartDTO;
import com.springcloud.common.result.BaseResult;
import com.springcloud.product.common.DecreaseStockInput;
import com.springcloud.product.entity.ProductInfo;
import com.springcloud.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<Long> productIdList){
        return (List<ProductInfo>) productInfoService.listByIds(productIdList);

    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productInfoService.decreaseStock(decreaseStockInputList);
    }

}

