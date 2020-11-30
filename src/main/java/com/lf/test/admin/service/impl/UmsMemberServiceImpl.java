package com.lf.test.admin.service.impl;

import com.lf.test.admin.common.CommonResult;
import com.lf.test.admin.service.RedisService;
import com.lf.test.admin.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Service
@Transactional
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;


    @Override
    public String generateSmsCode(String telephone) {
        //生成随机6位数验证码
        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return sb.toString();
    }

    @Override
    public CommonResult validSmsCode(String telephone, String smsCode) {
        String realsms=redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
        if (StringUtils.isEmpty(realsms)){
            return CommonResult.failed("验证码已过期");
        }
        if (smsCode.equals(realsms)){
            return CommonResult.success("验证通过");
        }
        return CommonResult.failed("验证码错误");
    }
}
