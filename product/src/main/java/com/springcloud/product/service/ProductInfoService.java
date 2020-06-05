package com.springcloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.product.common.DecreaseStockInput;
import com.springcloud.product.entity.ProductInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
public interface ProductInfoService extends IService<ProductInfo> {

    List<ProductInfo> findList(List<String> productIdList);

    @Transactional
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
