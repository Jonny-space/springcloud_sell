package com.springcloud.order.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.springcloud.common.dto.CartDTO;
import com.springcloud.common.result.BaseResult;
import com.springcloud.common.result.ResultVO;
import com.springcloud.order.common.client.ProductClient;
import com.springcloud.order.common.dto.OrderDTO;
import com.springcloud.order.common.entries.OrderDetail;
import com.springcloud.order.common.entries.OrderMaster;
import com.springcloud.order.common.entries.ProductInfo;
import com.springcloud.common.enums.OrderStatusEnums;
import com.springcloud.common.enums.PayStatusEnum;
import com.springcloud.order.service.OrderDetailService;
import com.springcloud.order.service.OrderMasterService;
import com.springcloud.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 10:47 2020/6/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        long orderId = IdWorker.getId();
//        String orderId = KeyUtil.getUniqueKey();
        //查询商品信息（调用商品服务）
        List<Long> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);
        //读redis

        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    //单价x数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(IdWorker.getId());
                    //订单详情入库
                    orderDetailService.save(orderDetail);
                }
            }
        }
        //扣库存(调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e->new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster,"createTime");
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmout);
        orderMasterService.save(orderMaster);

        //发送websocket消息
        //webSocket.sendMessage("有新的订单");
        orderDTO.setOrderId(String.valueOf(orderId));
        return orderDTO;
    }
}
