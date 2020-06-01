package com.springcloud.product.service;

import com.springcloud.product.entity.ProductCategory;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    List<ProductCategory> getAll();
}
