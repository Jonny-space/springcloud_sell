package com.springcloud.product.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.springcloud.product.entity.ProductCategory;
import com.springcloud.product.mapper.ProductCategoryMapper;
import com.springcloud.product.service.ProductCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryMapper.selectList(new Condition());
    }
}
