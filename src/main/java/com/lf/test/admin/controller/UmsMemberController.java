package com.lf.test.admin.controller;

import com.lf.test.admin.common.CommonResult;
import com.lf.test.admin.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Api(tags = "UmsMemberController",description = "会员登陆注册管理")
@RestController
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @PostMapping("admin/member/getSmsCode")
    @ApiOperation("获取手机验证码")
    public CommonResult getSmsCode(String telephone){
        String smsCode = umsMemberService.generateSmsCode(telephone);
        if (!StringUtils.isEmpty(smsCode)) {
            return CommonResult.success(smsCode,"获取验证码成功");
        }
        return CommonResult.failed("获取验证码失败");
    }

    @ApiOperation("校验输入验证码")
    @PostMapping("/admin/member/validSmsCode")
    public CommonResult validSmsCode(String telephone,String smsCode){
        return umsMemberService.validSmsCode(telephone,smsCode);
    }


}
