package com.lf.test.admin.service.impl;

import com.lf.test.admin.common.CancelOrderReceiver;
import com.lf.test.admin.common.CancelOrderSender;
import com.lf.test.admin.common.CommonResult;
import com.lf.test.admin.dto.OrderParam;
import com.lf.test.admin.service.OmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Service
@Slf4j
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        log.info("下单成功，获取到订单id：{}", 1L);
        long delayTime=30*1000;
        //发送延迟信息
        cancelOrderSender.sendMessage(1L,delayTime);
        return CommonResult.success("下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        log.info("根据orderId取消超时订单：{}", orderId);
    }
}
