package com.lf.test.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lf.test.admin.monogdb.document.MemberReadHistory;
import com.lf.test.admin.monogdb.repository.MemberReadHistoryRepository;
import com.lf.test.admin.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;


    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> memberReadHistoryList = new ArrayList<>(ids.size());
        for (String id:ids) {
            MemberReadHistory mrh = new MemberReadHistory();
            mrh.setId(id);
            memberReadHistoryList.add(mrh);
        }
        memberReadHistoryRepository.deleteAll(memberReadHistoryList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> listPage(Long memberId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
