package com.lf.test.admin.controller;

import com.lf.test.admin.common.CommonResult;
import com.lf.test.admin.dto.OrderParam;
import com.lf.test.admin.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "OmsOrderController",description = "订单管理")
public class OmsOrderController {

    @Autowired
    private OmsOrderService omsOrderService;

    @ApiOperation("下单生成订单")
    @RequestMapping(value = "/admin/oms/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam){
        return omsOrderService.generateOrder(orderParam);
    }
}
