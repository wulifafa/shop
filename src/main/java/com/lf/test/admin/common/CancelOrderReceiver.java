package com.lf.test.admin.common;

import com.lf.test.admin.service.OmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的接收者
 * 用于取消订单的队列里接收消息 shop.order.cancel
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Component
@RabbitListener(queues = "shop.order.cancel")
@Slf4j
public class CancelOrderReceiver {

    @Autowired
    private OmsOrderService omsOrderService;

    @RabbitHandler
    public void handle(Long orderId){
        log.info("接收队列取消订单的消息：{}", orderId);
        omsOrderService.cancelOrder(orderId);
    }
}
