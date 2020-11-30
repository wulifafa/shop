package com.lf.test.admin.monogdb.repository;

import com.lf.test.admin.monogdb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

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
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {

    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
