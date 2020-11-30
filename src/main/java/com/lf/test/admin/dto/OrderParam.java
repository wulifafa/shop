package com.lf.test.admin.dto;

import lombok.Data;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Data
public class OrderParam {
    //收货地址id
    private Long memeberAddressId;
    //优惠券id
    private Long couponId;
    //使用的积分
    private Integer useIntegration;
    //支付的方式
    private Integer payType;}
