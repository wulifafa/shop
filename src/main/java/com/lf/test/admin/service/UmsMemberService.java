package com.lf.test.admin.service;

import com.lf.test.admin.common.CommonResult;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface UmsMemberService {

    /**
     * 根据手机生成手机验证码
     * @param telephone
     * @return
     */
    String generateSmsCode(String telephone);

    /**
     * 校验输入的手机验证码
     * @param telephone
     * @param smsCode
     * @return
     */
    CommonResult validSmsCode(String telephone, String smsCode);
}
