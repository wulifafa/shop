package com.lf.test.admin.controller;

import com.lf.test.admin.common.CommonPage;
import com.lf.test.admin.common.CommonResult;
import com.lf.test.admin.monogdb.document.MemberReadHistory;
import com.lf.test.admin.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@RestController
@Api(tags = "MemberReadHistoryController",description = "会员商品浏览记录管理")
public class MemberReadHistoryController {

    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/admin/ums/createReadHistory", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        if (memberReadHistoryService.create(memberReadHistory)>0) {
            return CommonResult.success("添加记录成功");
        }
        return CommonResult.failed("添加记录失败");
    }

    @ApiOperation("批量删除会员的浏览记录")
    @RequestMapping(value = "/admin/ums/deleteReadHistory",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<String> ids){
        if (memberReadHistoryService.delete(ids)>0) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @ApiOperation("分页查询会员的浏览记录")
    @RequestMapping(value = "/admin/ums/listPageReadHistory",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<MemberReadHistory>> listPage(@RequestParam("memberId") Long memberId,
                                                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.listPage(memberId,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(memberReadHistoryList));
    }
}
