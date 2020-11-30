package com.lf.test.admin.service;

import com.lf.test.admin.common.CommonResult;
import com.lf.test.admin.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单管理接口
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface OmsOrderService {

    /**
     * 下单生成订单
     * @return
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消某个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);

}
