package com.lf.test.admin.service;

import com.lf.test.admin.monogdb.document.MemberReadHistory;

import java.util.List;

/**
 * 〈会员浏览记录管理Service〉
 *
 * @author LF
 * @Date 2020/11/27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 分页获取用户浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> listPage(Long memberId,Integer pageNum,Integer pageSize);
}
