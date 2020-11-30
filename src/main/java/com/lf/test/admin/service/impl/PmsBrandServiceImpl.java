package com.lf.test.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lf.test.admin.mbg.mapper.PmsBrandMapper;
import com.lf.test.admin.mbg.model.PmsBrand;
import com.lf.test.admin.service.PmsBrandSercvcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional
public class PmsBrandServiceImpl implements PmsBrandSercvcie {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(null);
    }

    @Override
    public int insert(PmsBrand pmsBrand) {
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public int delete(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(PmsBrand pmsBrand) {
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }
}
