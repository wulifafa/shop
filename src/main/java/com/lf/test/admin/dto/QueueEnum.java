package com.lf.test.admin.dto;

import lombok.Getter;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Getter
public enum  QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("shop.order.direct","shop.order.cancel","shop.order.cancel"),

    QUEUE_TTL_ORDER_CANCEL("shop.order.direct.ttl", "shop.order.cancel.ttl", "shop.order.cancel.ttl");


    private String exchange;

    private String name;

    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange=exchange;
        this.name=name;
        this.routeKey=routeKey;
    }
}
