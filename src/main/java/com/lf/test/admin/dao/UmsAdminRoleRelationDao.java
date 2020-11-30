package com.lf.test.admin.dao;

import com.lf.test.admin.mbg.model.UmsPermission;

import java.util.List;

/**
 * 用户与角色关系自定义dao
 *
 * @author LF
 * @Date 2020/11/26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户的所有权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
