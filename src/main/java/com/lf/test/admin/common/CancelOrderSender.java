package com.lf.test.admin.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Slf4j
@Component
public class CancelOrderSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void  sendMessage(Long orderId,Long dalayTimes){
        //给延迟队列发送消息
         log.info((dalayTimes/1000)+"秒后发送取消订单的消息给订单：{}",orderId);
    }
}
