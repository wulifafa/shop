package com.lf.test.admin.service;

import com.lf.test.admin.mbg.model.UmsAdmin;
import com.lf.test.admin.mbg.model.UmsPermission;

import java.util.List;

/**
 * 用户管理admin
 *
 * @author LF
 * @Date 2020/11/26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface UmsAdminService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 用户注册
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 根据用户id查询用户权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
