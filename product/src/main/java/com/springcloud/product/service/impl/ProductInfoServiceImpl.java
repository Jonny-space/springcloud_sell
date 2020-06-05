package com.springcloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.common.enums.ResultEnums;
import com.springcloud.common.exception.SellException;
import com.springcloud.product.common.DecreaseStockInput;
import com.springcloud.product.common.ProductInfoOutput;
import com.springcloud.product.entity.ProductInfo;
import com.springcloud.product.mapper.ProductInfoMapper;
import com.springcloud.product.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
   @Autowired
   private ProductInfoMapper mapper;
//    @Autowired
//    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return mapper.selectBatchIds(productIdList);
    }
    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);
        //发送mq消息
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e->{
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(e,output);
            return output;
        }).collect(Collectors.toList());
//        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJSON(productInfoOutputList));
    }
    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
        for(DecreaseStockInput decreaseStockInput:decreaseStockInputList){
            ProductInfo productInfo  = getById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if(productInfo == null){
                throw new SellException(ResultEnums.PRODUCT_NOT_EXIST);
            }
            //库存是否足够
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnums.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            saveOrUpdate(productInfo);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }

}
