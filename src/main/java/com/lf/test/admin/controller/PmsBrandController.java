package com.lf.test.admin.controller;

import com.lf.test.admin.common.CommonPage;
import com.lf.test.admin.common.CommonResult;
import com.lf.test.admin.mbg.model.PmsBrand;
import com.lf.test.admin.service.PmsBrandSercvcie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Slf4j
@RestController
@Api(tags = "PmsBrandController: 商品品牌管理")
public class PmsBrandController {

    @Autowired
    private PmsBrandSercvcie pmsBrandService;

    @GetMapping("/admin/brand/getList")
    @ResponseBody
    @ApiOperation("分页获取所有品牌")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<CommonPage<PmsBrand>> getList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                      @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        List<PmsBrand> list=pmsBrandService.getList(pageNum, pageSize);
        log.info("分页查询所有品牌==》"+list);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @RequestMapping(value = "/admin/brand/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("添加品牌")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult insert(PmsBrand pmsBrand){
        int count = pmsBrandService.insert(pmsBrand);
        log.info("添加品牌==》" + count);
        if (count>0) {
            return CommonResult.success("添加品牌成功");
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "/admin/brand/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("删除品牌")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult delete(Long id){
        int count = pmsBrandService.delete(id);
        log.info("删除品牌==》" + count);
        if (count>0) {
            return CommonResult.success("删除品牌成功");
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "/admin/brand/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("更新品牌")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult update(PmsBrand pmsBrand){
        int count = pmsBrandService.update(pmsBrand);
        log.info("更新品牌==》" + count);
        if (count>0) {
            return CommonResult.success("更新品牌成功");
        }
        return CommonResult.failed();
    }

}
