package com.lf.test.admin.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务 订单超时自动取消并释放库存商品
 *
 * @author LF
 * @Date 2020/11/26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */

@Component
@Slf4j
public class OrderTimeOutCancelTask {

    @Scheduled(cron = "0 0/10 * ? * ?")
    public void cancelTimeOutOrder(){
        //todo 从零点开始 每10分钟扫描一次 查询未支付订单
        log.info("取消订单，并释放库存");
    }
}
