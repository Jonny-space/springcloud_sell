package com.springcloud.product.service.impl;

import com.springcloud.product.entity.ProductInfo;
import com.springcloud.product.mapper.ProductInfoMapper;
import com.springcloud.product.service.ProductInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭建锋
 * @since 2020-06-01
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

}
